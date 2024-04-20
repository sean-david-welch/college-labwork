class Carousel {
	constructor() {
		this.currentIndex = 0;
		this.setupSlider();
		this.dialog = document.getElementById('d');
	}

	updateImageVisibility(images) {
		images.forEach((img, index) => {
			img.classList.remove('fade-in', 'fade-out');
			img.classList.add(index === this.currentIndex ? 'fade-in' : 'fade-out');
		});
	}

	setupSlider() {
		const carouselContainer = document.querySelector('#carousel');
		carouselContainer.innerHTML = '';

		carData.cars.forEach(car => {
			const img = document.createElement('img');
			img.src = car.image;
			img.alt = 'car-image';
			img.classList.add('slides');
			carouselContainer.appendChild(img);

			img.addEventListener('click', () => {
				this.showCarInfo(this.currentIndex);
				this.setupDialog();
			});
		});

		const images = document.querySelectorAll('#carousel .slides');

		this.updateImageVisibility(images);

		const prevButton = document.querySelector('.prev-button');
		const nextButton = document.querySelector('.next-button');

		const nextStep = () => {
			this.currentIndex = this.currentIndex === images.length - 1 ? 0 : this.currentIndex + 1;
			this.updateImageVisibility(images);
		};

		const prevStep = () => {
			this.currentIndex = this.currentIndex === 0 ? images.length - 1 : this.currentIndex - 1;
			this.updateImageVisibility(images);
		};

		prevButton.addEventListener('click', prevStep);
		nextButton.addEventListener('click', nextStep);
	}

	showCarInfo(index) {
		const car = carData.cars[index];
		this.dialog.innerHTML = `
			<div class="car-info">
				<h1 class="section-heading">${car.name}</h1>
				<p class="subheading">${car.type}</p>
				<p class="subheading">Starting at: ${car.starting_price}</p>
				<a class="btn" onclick="d.close()">Close</a>
			</div>
		`;
	}

	setupDialog() {
		setTimeout(() => {
			this.dialog.showModal();
		}, 50);
	}
}

document.addEventListener('DOMContentLoaded', () => {
	new Carousel();
});
