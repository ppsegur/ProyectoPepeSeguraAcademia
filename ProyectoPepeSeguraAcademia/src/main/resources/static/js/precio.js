function validateForm() {
			var precio = document.getElementById('precio').value;
			if (precio < 1) {
				alert("El precio debe ser mayor o igual a 1");
				return false;
			}
			return true;
		}