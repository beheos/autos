// Obtenemos todos los elementos <a> dentro de la lista con clase "nav-item"
  const navLinks = document.querySelectorAll('.nav-item a');
  const navLinksHijo = document.querySelectorAll('.nav-item-hijo a');

  // Recorremos los elementos y agregamos un event listener para manejar el clic
  navLinks.forEach(function(navLink) {
    navLink.addEventListener('click', function(event) {


      // Removemos la clase "active" de todos los elementos
      navLinks.forEach(function(link) {
        link.classList.remove('active');
      });

      // Agregamos la clase "active" al elemento seleccionado
      this.classList.add('active');
    });
  });