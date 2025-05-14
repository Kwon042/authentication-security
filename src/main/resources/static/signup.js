document.getElementById('signup-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = {
        username: document.getElementById('username').value,
        email: document.getElementById('email').value,
        password: document.getElementById('password').value
    };

    fetch('/api/users/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => {
        if (!response.ok) {
            return response.text().then(text => { throw new Error(text); });
        }
        return response.json();
    })
    .then(data => {
        alert('Signup successful! Welcome, ' + data.username);
        window.location.href = '/'; // 홈으로 이동
    })
    .catch(error => {
        console.error('Error:', error);
        alert(error.message);
    });
});