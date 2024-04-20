// function toggleNavbarTransparency() {
//     const navbar = document.querySelector('.navbar');
//     if (window.scrollY > 50) {
//         navbar.classList.remove('transparent-nav');
//     } else {
//         navbar.classList.add('transparent-nav');
//     }
// }

// if (window.innerWidth > 768) {
//     window.addEventListener('scroll', toggleNavbarTransparency);
// }

// jquery version
$(document).ready(function () {
	function toggleNavbarTransparency() {
		if ($(window).scrollTop() > 50) {
			$('.navbar').removeClass('transparent-nav');
		} else {
			$('.navbar').addClass('transparent-nav');
		}
	}

	// Check if the viewport width is more than 768px before attaching the event
	if ($(window).width() > 768) {
		$(window).scroll(toggleNavbarTransparency);
	}
});
