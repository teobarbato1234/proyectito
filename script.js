document.addEventListener("DOMContentLoaded", () => {
    
    const feedback = document.getElementById("feedback");
    const params = new URLSearchParams(window.location.search);

    
    if (params.has("error")) {
        feedback.textContent = params.get("error");
        feedback.className = "error";
    } else if (params.has("success")) {
        feedback.textContent = params.get("success");
        feedback.className = "success";
    }

     
    const registerForm = document.getElementById('registerForm');
    
    if (registerForm) {
        registerForm.addEventListener('submit', function(event) {
            const user = document.getElementById('username').value;
            const pass = document.getElementById('password').value;

            
            const hasLetter = /[a-zA-Z]/.test(user); 
            const hasNumber = /[0-9]/.test(user); 

            if (!hasLetter || !hasNumber) {
                event.preventDefault(); 
                feedback.textContent = "Username must contain at least one letter and one number.";
                feedback.className = "error";
                return; 
            }

        
            const hasLowercase = /[a-z]/.test(pass); 
            const hasUppercase = /[A-Z]/.test(pass); 
            const hasDigit = /[0-9]/.test(pass); 
            const hasSpecialChar = /[!@#\$%\^&\*\(\)_\+\-=\[\]{};':"\\|,.<>\/?]/.test(pass); 
            
            
            const userLength = user.length;
            const passLength = pass.length;
            const isUserTooShort = userLength < 5;

            if (isUserTooShort) {
                event.preventDefault();
                feedback.textContent = "Username must be at least 5 characters.";
                feedback.className = "error";
                return;
            }

            const minimo = passLength < 8;

            if (minimo) {
                event.preventDefault();
                feedback.textContent = "Password must be at least 8 characters.";
                feedback.className = "error";
                return;
            }

            const maximo = passLength > 15;

            if (maximo) {
                event.preventDefault();
                feedback.textContent = "Password must be no more than 15 characters.";
                feedback.className = "error";
                return;
            }

            const maximoUser = userLength > 15;

            if (maximoUser) {
                event.preventDefault();
                feedback.textContent = "Username must be no more than 15 characters.";
                feedback.className = "error";
                return;
            }

            if (!hasLowercase || !hasUppercase || !hasDigit || !hasSpecialChar) {
                event.preventDefault();
                feedback.textContent = "Password must contain a lowercase, uppercase, number, and special character.";
                feedback.className = "error";
                return;
            }
            
            
        });
    }
});