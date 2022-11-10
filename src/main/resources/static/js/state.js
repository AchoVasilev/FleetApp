document.addEventListener('DOMContentLoaded', async function () {
    const editModal = document.getElementById('editModal');
    editModal.addEventListener('show.bs.modal', ev => onEditModal(ev, editModal));

    const deleteModal = document.getElementById('deleteModal');
    deleteModal.addEventListener('show.bs.modal', ev => onDeleteModal(ev, deleteModal));
});

function onDeleteModal(ev, deleteModal) {
    let btn = ev.relatedTarget;

    const stateId = btn.id;

    const deleteBtn = document.getElementById('delete-btn');
    deleteBtn.addEventListener('click', ev => onDelete(ev, deleteModal, stateId));
}

async function onDelete(ev, deleteModal, stateId) {
    ev.preventDefault();

    try {
        const response = await fetch('/api/states/' + stateId, {
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

    const stateId = btn.id;

    try {
        const response = await fetch('/api/states/' + stateId);
        if (response.ok === false) {
            const err = await response.json();
            throw new Error(err);
        }

        const body = await response.json();

        const name = document.getElementById('name-edit');
        name.value = body.name;

        const capital = document.getElementById('capital-edit');
        capital.value = body.capital;

        const code = document.getElementById('code-edit');
        code.value = body.code;

        const form = document.getElementById('edit-form');
        form.addEventListener('submit', e => handleSubmit(e, modalEl, stateId))


    } catch (error) {
        console.log(error.message);
    }
}

async function handleSubmit(e, modalEl, stateId) {
    e.preventDefault();
    const formData = new FormData(e.target);
    const name = formData.get('name');
    const capitalData = formData.get('capital');
    const codeData = formData.get('code');
    //
    // const xsrfHeader = document.getElementById('token').name;
    // const token = document.getElementById('token').value;

    // let tokenInput = document.getElementById('token');
    // let token = tokenInput.value;
    // let header = tokenInput.name;

    const data = {
        id: stateId,
        name: name,
        capital: capitalData,
        code: codeData,
    };

    const headers = new Headers();
    //headers.set(header, token);
    headers.set('content-type', 'application/json');

    try {
        const response = await fetch('/api/states/editById/' + stateId, {
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