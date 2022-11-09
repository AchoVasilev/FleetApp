document.addEventListener('DOMContentLoaded', async function () {
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

            const form = document.getElementById('edit-form');
            form.addEventListener('submit', async function (e) {
                const formData = new FormData(ev.target);
                const descData = formData.get('description');
                const capitalData = formData.get('capital');
                const codeData = formData.get('code');
                const continentData = formData.get('continent');
                const nationalityData = formData.get('nationality');

                const data = {
                    description: descData,
                    capital: capitalData,
                    code: codeData,
                    continent: continentData,
                    nationality: nationalityData
                };

                try {
                    const response = await fetch('http://localhost:8080/countries/' + countryId, {
                        method: 'put',
                        headers: {
                            'content-type': 'application/json'
                        },
                        body: JSON.stringify(data)
                    });

                    if(response.ok != true) {
                        const error = await response.json();
                        throw new Error(error.message);
                    }

                    const obj = await response.json();
                    ev.target.reset();
                    modalEl.style.display = 'none';
                } catch (err) {
                    console.log(err.message);
                }
            });

        } catch (error) {
            console.log(error.message);
        }
    });
});