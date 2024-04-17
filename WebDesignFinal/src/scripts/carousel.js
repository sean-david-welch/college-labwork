let currentIndex = 0;

function updateImageVisibility(images, currentIndex) {
	images.forEach((img, index) => {
		img.classList.remove('fade-in', 'fade-out');
		img.classList.add(index === currentIndex ? 'fade-in' : 'fade-out');
	});
}

function setupSlider() {
	const images = document.querySelectorAll('#carousel .slides');
	const prevButton = document.querySelector('.prev-button');
	const nextButton = document.querySelector('.next-button');

	updateImageVisibility(images, currentIndex);

	const nextStep = () => {
		currentIndex = currentIndex === images.length - 1 ? 0 : currentIndex + 1;
		updateImageVisibility(images, currentIndex);
	};

	const prevStep = () => {
		currentIndex = currentIndex === 0 ? images.length - 1 : currentIndex - 1;
		updateImageVisibility(images, currentIndex);
	};

	prevButton.addEventListener('click', prevStep);
	nextButton.addEventListener('click', nextStep);
}

document.addEventListener('DOMContentLoaded', setupSlider);
