document.addEventListener('DOMContentLoaded', async function () {
    const editModal = document.getElementById('editModal');
    editModal.addEventListener('show.bs.modal', ev => onEditModal(ev, editModal));

    const deleteModal = document.getElementById('deleteModal');
    deleteModal.addEventListener('show.bs.modal', ev => onDeleteModal(ev, deleteModal));
});

function onDeleteModal(ev, deleteModal) {
    let btn = ev.relatedTarget;

    const locationId = btn.id;

    const deleteBtn = document.getElementById('delete-btn');
    deleteBtn.addEventListener('click', ev => onDelete(ev, deleteModal, locationId));
}

async function onDelete(ev, deleteModal, locationId) {
    ev.preventDefault();

    try {
        const response = await fetch('/api/locations/' + locationId, {
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

    const locationId = btn.id;

    try {
        const response = await fetch('/api/locations/' + locationId);
        if (response.ok === false) {
            const err = await response.json();
            throw new Error(err);
        }

        const body = await response.json();

        const city = document.getElementById('city-edit');
        city.value = body.city;

        const address = document.getElementById('address-edit');
        address.value = body.address;

        const description = document.getElementById('description-edit');
        description.value = body.description;

        const details = document.getElementById('details-edit');
        details.value = body.details;

        const form = document.getElementById('edit-form');
        form.addEventListener('submit', e => handleSubmit(e, modalEl, locationId))


    } catch (error) {
        console.log(error.message);
    }
}

async function handleSubmit(e, modalEl, locationId) {
    e.preventDefault();
    const formData = new FormData(e.target);
    const city = formData.get('city');
    const address = formData.get('address');
    const description = formData.get('description');
    const details = formData.get('details');
    //
    // const xsrfHeader = document.getElementById('token').name;
    // const token = document.getElementById('token').value;

    // let tokenInput = document.getElementById('token');
    // let token = tokenInput.value;
    // let header = tokenInput.name;

    const data = {
        id: locationId,
        city,
        address,
        description,
        details
    };

    const headers = new Headers();
    //headers.set(header, token);
    headers.set('content-type', 'application/json');

    try {
        const response = await fetch('/api/locations/editById/' + locationId, {
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