.// TO DO

document.getElementById("login-btn").addEventListener("click", function() {

    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    fetch("/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ username: username, password: password })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Invalid username or password");
            }

            document.getElementById("username").value = "";
            document.getElementById("password").value = "";
            alert("Login successful!");
        })
        .catch(error => {
            console.error("Login error:", error);
            alert("Login failed. Please try again.");
        });
});