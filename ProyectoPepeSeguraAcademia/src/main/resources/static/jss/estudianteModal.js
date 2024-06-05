 	
 	$('#confirmDeleteModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var userId = button.data('id');
        var userRole = button.data('role');
        var modal = $(this);

        modal.find('#confirmDeleteButton').attr('href', '/admin/borrarEstudiante/' + userId);

        if (userRole === 'true') {
            modal.find('#adminWarning').text(' Este usuario es un administrador.');
            modal.find('#confirmDeleteButton').prop('disabled', true); // Deshabilitar el botón de eliminación
        } else {
            modal.find('#adminWarning').text('');
            modal.find('#confirmDeleteButton').prop('disabled', false); // Habilitar el botón de eliminación
        }
    });