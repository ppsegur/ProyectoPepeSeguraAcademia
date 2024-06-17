 document.getElementById('studentForm').addEventListener('submit', function(event) {
        let form = event.target;
        let isValid = true;

        let fields = ['username', 'contrasena', 'nombre', 'apellidos', 'correo', 'dni', 'edad'];

        fields.forEach(function(field) {
            let input = document.getElementById(field);
            if (!input.value.trim()) {
                input.classList.add('is-invalid');
                isValid = false;
            } else {
                input.classList.remove('is-invalid');
            }
        });

        // Validar el username
        let username = document.getElementById('username');
        if (username.value.length < 2) {
            username.classList.add('is-invalid');
            document.getElementById('usernameFeedback').style.display = 'block';
            isValid = false;
        } else {
            username.classList.remove('is-invalid');
            document.getElementById('usernameFeedback').style.display = 'none';
        }

        // Validar el correo
        let correo = document.getElementById('correo');
		let correoPattern = /@/;
		        if (!correoPattern.test(correo.value)) {
            correo.classList.add('is-invalid');
            document.getElementById('emailFeedback').style.display = 'block';
            isValid = false;
        } else {
            correo.classList.remove('is-invalid');
            document.getElementById('emailFeedback').style.display = 'none';
        }
		
		   // Validación de edad mínima de 18 años
		 let fechaNacimiento = document.getElementById('fechaNacimiento');
		 let fecha = new Date(fechaNacimiento.value);
		 let hoy = new Date();
		 let edadMinima = new Date(hoy.getFullYear() - 18, hoy.getMonth(), hoy.getDate());
		
		   if (fecha > edadMinima) {
	        fechaNacimiento.classList.add('is-invalid');
			document.getElementById('ageFeedback').style.display = 'block';
		           isValid = false;
		   } else {
		     fechaNacimiento.classList.remove('is-invalid');
		      document.getElementById('ageFeedback').style.display = 'none';
		   }
		
		    if (!isValid) {
		        event.preventDefault();
	      }
		    
    });