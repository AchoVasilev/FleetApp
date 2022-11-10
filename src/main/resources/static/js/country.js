document.addEventListener('DOMContentLoaded', async function () {
    const editModal = document.getElementById('editModal');
    editModal.addEventListener('show.bs.modal', ev => onEditModal(ev, editModal));

    const deleteModal = document.getElementById('deleteModal');
    deleteModal.addEventListener('show.bs.modal', ev => onDeleteModal(ev, deleteModal));
});

function onDeleteModal(ev, deleteModal) {
    let btn = ev.relatedTarget;

    const countryId = btn.id;

    const deleteBtn = document.getElementById('delete-btn');
    deleteBtn.addEventListener('click', ev => onDelete(ev, deleteModal, countryId));
}

async function onDelete(ev, deleteModal, countryId) {
    ev.preventDefault();

    try {
        const response = await fetch('/api/countries/' + countryId, {
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

    const countryId = btn.id;

    try {
        const response = await fetch('/api/countries/' + countryId);
        if (response.ok === false) {
            const err = await response.json();
            throw new Error(err);
        }

        const body = await response.json();

        const description = document.getElementById('description-edit');
        description.value = body.description;

        const capital = document.getElementById('capital-edit');
        capital.value = body.capital;

        const code = document.getElementById('code-edit');
        code.value = body.code;

        const continent = document.getElementById('continent-edit');
        continent.value = body.continent;

        const nationality = document.getElementById('nationality-edit');
        nationality.value = body.nationality;

        const form = document.getElementById('edit-form');
        form.addEventListener('submit', e => handleSubmit(e, modalEl, countryId))


    } catch (error) {
        console.log(error.message);
    }
}

async function handleSubmit(e, modalEl, countryId) {
    const formData = new FormData(e.target);
    const descData = formData.get('description');
    const capitalData = formData.get('capital');
    const codeData = formData.get('code');
    const continentData = formData.get('continent');
    const nationalityData = formData.get('nationality');
    //
    // const xsrfHeader = document.getElementById('token').name;
    // const token = document.getElementById('token').value;

    // let tokenInput = document.getElementById('token');
    // let token = tokenInput.value;
    // let header = tokenInput.name;

    const data = {
        description: descData,
        capital: capitalData,
        code: codeData,
        continent: continentData,
        nationality: nationalityData
    };

    const headers = new Headers();
    //headers.set(header, token);
    headers.set('content-type', 'application/json');

    try {
        const response = await fetch('/api/countries/editById/' + countryId, {
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
    } catch (err) {
        console.log(err.message);
    }
}