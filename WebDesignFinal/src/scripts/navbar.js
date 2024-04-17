function toggleNavbarTransparency() {
	const navbar = document.querySelector('.navbar');
	if (window.scrollY > 50) {
		navbar.classList.remove('transparent-nav');
	} else {
		navbar.classList.add('transparent-nav');
	}
}

window.addEventListener('scroll', toggleNavbarTransparency);
