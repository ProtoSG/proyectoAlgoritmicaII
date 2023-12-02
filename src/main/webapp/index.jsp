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
                    <h2>Iniciar Sesión</h2>
                    <form class="user" action="SvLogin" method="POST">
                        <div class="input-box">
                            <span class="icon"><ion-icon name="person-outline"></ion-icon></span>
                            <input type="text" id="userName" name="userName" required>
                            <label>Username</label>
                        </div>
                        <div class="input-box">
                            <span class="icon"><ion-icon name="lock-closed-outline"></ion-icon></span>
                            <input type="password" id="contrasena" name="contrasena" required>
                            <label>Password</label>
                        </div>

                        <button type="submit" class="btn">Iniciar Sesión</button>
                        <div class="login-register">
                            <p>No tienes una cuenta? <a href="#" class="register-link">Register</a></p>
                        </div>
                    </form>
                </div>
                <div class="form-box register">
                    <h2>Regístrate</h2>
                    <form class="user" action="SvUsuario" method="POST">
                        <div class="input-box">
                            <span class="icon"><ion-icon name="reader-outline"></ion-icon></span>
                            <input type="text" id="name" name="name" required>
                            <label>Name</label>
                        </div>
                        <div class="input-box">
                            <span class="icon"><ion-icon name="reader-outline"></ion-icon></span>
                            <input type="text" id="lastName" name="lastName" required>
                            <label>Last Name</label>
                        </div>

                        <div class="input-box">
                            <span class="icon"><ion-icon name="calendar-outline"></ion-icon></span>
                            <input type="date" id="date" name="date" required>
                        </div>
                        <div class="input-box">
                            <span class="icon"><ion-icon name="person-outline"></ion-icon></span>
                            <input type="text" id="nombreUsuario" name="nombreUsuario" required>
                            <label>Username</label>
                        </div>
                        <div class="input-box">
                            <span class="icon"><ion-icon name="lock-closed-outline"></ion-icon></span>
                            <input type="password" id="contrasena" name="contrasena" required>
                            <label>Password</label>
                        </div>
                        <div id="carreraProfesional" class="input-box">
                            <span class="icon"><ion-icon name="person-outline"></ion-icon></span>
                            <input type="text" id="carreraProfesional" name="carreraProfesional">
                            <label>Carrera Profesional</label>
                        </div>
                        <div class="checkbox-group">
                            <div>
                            <input type="checkbox" id="profesor" name="profesor" checked onclick="uncheck()">
                            <label for="profesor">Profesor</label>
                            </div>
                            <div>
                            <input type="checkbox" id="alumno" name="alumno" onclick="uncheck()">
                            <label for="alumno">Alumno</label>
                            </div>
                        </div>
 
                        <button type="submit" class="btn">Register</button>
                        <div class="login-register">
                            <p>Ya tienes una cuenta? <a href="#" class="login-link">Login</a></p>
                        </div>
                    </form>
          
                </div>

            </div>
        </div>
        
        <<script src="scripts/login-register.js"></script>
    </body>
</html>
