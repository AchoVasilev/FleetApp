document.addEventListener('DOMContentLoaded', async function () {
    const editModal = document.getElementById('editModal');
    editModal.addEventListener('show.bs.modal', ev => onEditModal(ev, editModal));

    const deleteModal = document.getElementById('deleteModal');
    deleteModal.addEventListener('show.bs.modal', ev => onDeleteModal(ev, deleteModal));
});

function onDeleteModal(ev, deleteModal) {
    let btn = ev.relatedTarget;

    const vehicleStatusId = btn.id;

    const deleteBtn = document.getElementById('delete-btn');
    deleteBtn.addEventListener('click', ev => onDelete(ev, deleteModal, vehicleStatusId));
}

async function onDelete(ev, deleteModal, vehicleStatusId) {
    ev.preventDefault();

    try {
        const response = await fetch('/api/vehicleStatus/' + vehicleStatusId, {
            method: 'delete',
            headers: {
                'content-type': 'application/json'
            }
        });

        if (response.ok !== true) {
            const error = await response.json();
            throw new Error(error.message);
        }

        await response.json();
        deleteModal.style.display = 'none';
    } catch (err) {
        console.log(err);
    }
}

async function onEditModal(ev, modalEl) {
    let btn = ev.relatedTarget;

    const vehicleStatusId = btn.id;

    try {
        const response = await fetch('/api/vehicleStatus/' + vehicleStatusId);
        if (response.ok === false) {
            const err = await response.json();
            throw new Error(err);
        }

        const body = await response.json();

        const description = document.getElementById('description-edit');
        description.value = body.description;

        const details = document.getElementById('details-edit');
        details.value = body.details;

        const form = document.getElementById('edit-form');
        form.addEventListener('submit', e => handleSubmit(e, modalEl, vehicleStatusId))
    } catch (error) {
        console.log(error.message);
    }
}

async function handleSubmit(e, modalEl, vehicleStatusId) {
    e.preventDefault();
    const formData = new FormData(e.target);
    const description = formData.get('description');
    const details = formData.get('details');
    //
    // const xsrfHeader = document.getElementById('token').name;
    // const token = document.getElementById('token').value;

    // let tokenInput = document.getElementById('token');
    // let token = tokenInput.value;
    // let header = tokenInput.name;

    const data = {
        id: vehicleStatusId,
        description,
        details
    };

    const headers = new Headers();
    //headers.set(header, token);
    headers.set('content-type', 'application/json');

    try {
        const response = await fetch('/api/vehicleStatus/editById/' + vehicleStatusId, {
            method: 'Put',
            headers,
            body: JSON.stringify(data)
        });

        if (response.ok !== true) {
            const error = await response.json();
            throw new Error(error.message);
        }

        await response.json();
        e.target.reset();
        modalEl.style.display = 'none';

        location.reload();
    } catch (err) {
        console.log(err.message);
    }
}