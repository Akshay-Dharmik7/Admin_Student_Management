document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('#registration-form');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const name = document.querySelector('#name').value;
        const address = document.querySelector('#address').value;
        const subjects = document.querySelector('#subjects').value;

        fetch('/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: new URLSearchParams({
                'name': name,
                'address': address,
                'subjects': subjects
            })
        })
        .then(response => response.text())
        .then(data => {
            alert('Student registered successfully!');
            form.reset();
        });
    });
});
