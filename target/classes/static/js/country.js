document.addEventListener('DOMContentLoaded', async function () {
    // let editBtn = document.getElementById('editBtn');
    // editBtn.addEventListener('click', function (ev) {
    //     let modal = new bootstrap.Modal(document.getElementById('editModal'));
    //     modal.show()
    // });

    const modalEl = document.getElementById('editModal');
    modalEl.addEventListener('show.bs.modal', async function (ev) {

        let btn = ev.relatedTarget;

        const countryId = btn.id;

        try {
            const response = await fetch('http://localhost:8080/countries/' + countryId);
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

        } catch (error) {
            console.log(error.message);
        }
    });
});