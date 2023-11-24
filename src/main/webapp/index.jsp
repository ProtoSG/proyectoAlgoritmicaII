<%-- 
    Document   : index
    Created on : 23 nov. 2023, 09:42:08
    Author     : dgocr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Juez Cachimbo</title>
        <link rel="stylesheet" href="styles/style.css"/>
    </head>
    <body>
        <div class="container">
            <div class="containerLogo">
            </div>
            <div class="wrapper">
                <div class="form-box login">
                    <h2>Welcome !</h2>
                    <form action="#">
                        <div class="input-box">
                            <span class="icon"><ion-icon name="person-outline"></ion-icon></span>
                            <input type="text" required>
                            <label>Username</label>
                        </div>
                        <div class="input-box">
                            <span class="icon"><ion-icon name="lock-closed-outline"></ion-icon></span>
                            <input type="password" required>
                            <label>Password</label>
                        </div>
                        <div class="forgot">
                            <a href="#">Forgot Password</a>
                        </div>
                        <button type="submit" class="btn">Login</button>
                        <div class="login-register">
                            <p>Don't have an account? <a href="#" class="register-link">Register</a></p>
                        </div>
                    </form>
                </div>
                <div class="form-box register">
                    <h2>Registration</h2>
                    <form action="#">
                        <div class="input-box">
                            <span class="icon"><ion-icon name="reader-outline"></ion-icon></span>
                            <input type="text" required>
                            <label>Name</label>
                        </div>
                        <div class="input-box">
                            <span class="icon"><ion-icon name="reader-outline"></ion-icon></span>
                            <input type="text" required>
                            <label>Last Name</label>
                        </div>

                        <div class="input-box">
                            <span class="icon"><ion-icon name="calendar-outline"></ion-icon></span>
                            <input type="date" required>
                        </div>
                        <div class="input-box">
                            <span class="icon"><ion-icon name="person-outline"></ion-icon></span>
                            <input type="text" required>
                            <label>Username</label>
                        </div>
                        <div class="input-box">
                            <span class="icon"><ion-icon name="lock-closed-outline"></ion-icon></span>
                            <input type="password" required>
                            <label>Password</label>
                        </div>
                        <button type="submit" class="btn">Register</button>
                        <div class="login-register">
                            <p>Already have an account? <a href="#" class="login-link">Login</a></p>
                        </div>
                    </form>
                </div>

            </div>
        </div>
        
        <<script src="scripts/login-register.js"></script>
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    </body>
</html>
