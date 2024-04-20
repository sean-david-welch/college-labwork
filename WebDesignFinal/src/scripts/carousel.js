const carData = {
	cars: [
		{
			name: 'Lamborghini Huracán',
			type: 'High-performance sports car',
			engine: 'Mid-mounted V10',
			variants: ['Huracán LP 610-4'],
			performance: {
				top_speed: '201 mph',
				acceleration: '0 to 60 mph in 3.2 seconds',
			},
			starting_price: '$200,000',
			image: '../assets/cars/lambo-hurucan.jpg',
			key_features: [],
			body_styles: [],
			drive_options: [],
		},
		{
			name: 'Mercedes-AMG GT',
			type: 'Luxury grand tourer sports car',
			engine: 'Twin-turbocharged V8',
			variants: [],
			performance: null,
			starting_price: 'Around €185,570 in Ireland',
			image: '../assets/cars/merc-gt.jpg',
			key_features: ['Electronically controlled suspension', 'Limited-slip differential'],
			body_styles: ['Coupe', 'Roadster'],
			drive_options: [],
		},
		{
			name: 'Range Rover Evoque',
			type: 'Luxury SUV',
			engine: null,
			variants: [],
			performance: null,
			starting_price: 'From €66,270 in Ireland',
			image: '../assets/cars/range-evoque.jpg',
			key_features: ['Stylish design', 'Off-road capability'],
			body_styles: [],
			drive_options: ['Front-wheel drive', 'All-wheel drive'],
		},
		{
			name: 'BMW 3 Series Gran Turismo',
			type: 'Four-door liftback',
			engine: null,
			variants: [],
			performance: null,
			starting_price: 'Approximately £35,629',
			image: '../assets/cars/bmw-3series.jpg',
			key_features: ['Sporty handling', 'Spacious cargo area'],
			body_styles: [],
			drive_options: [],
		},
		{
			name: 'Audi A5 Sportback',
			type: 'Stylish and sporty car',
			engine: null,
			variants: [],
			performance: null,
			starting_price: 'Around $41,400',
			image: '../assets/cars/audi-a5.jpg',
			key_features: ['Comfortable interior'],
			body_styles: [],
			drive_options: ['Front-wheel drive', 'All-wheel drive'],
		},
		{
			name: 'Mercedes-Benz A-Class',
			type: 'Luxurious compact car',
			engine: null,
			variants: [],
			performance: null,
			starting_price: 'About €32,100 in Ireland',
			image: '../assets/cars/marc-a-class.jpg',
			key_features: [],
			body_styles: [],
			drive_options: ['Front-wheel drive', 'All-wheel drive'],
		},
		{
			name: 'Maserati GranTurismo',
			type: 'Luxury sports car',
			engine: 'V8',
			variants: [],
			performance: null,
			starting_price: 'Around $148,885',
			image: '../assets/cars/maserati-gt.jpg',
			key_features: ['Stylish design'],
			body_styles: [],
			drive_options: [],
		},
		{
			name: 'Ford Focus',
			type: 'Compact car',
			engine: null,
			variants: [],
			performance: null,
			starting_price: 'Used models starting around €10,000 in Ireland',
			image: '../assets/cars/ford-focus.jpg',
			key_features: ['Affordability', 'Fuel efficiency'],
			body_styles: ['Sedan', 'Hatchback'],
			drive_options: [],
		},
		{
			name: 'Alfa Romeo 4C',
			type: 'Lightweight two-door sports car',
			engine: 'Mid-engine turbocharged',
			variants: [],
			performance: null,
			starting_price: 'Around €30,000 used',
			image: '../assets/cars/alfa-4c.jpg',
			key_features: ['Powerful engine'],
			body_styles: [],
			drive_options: [],
		},
		{
			name: 'Hyundai Santa Fe',
			type: 'Mid-size SUV',
			engine: null,
			variants: [],
			performance: null,
			starting_price: 'Used models starting at €25,000 in Ireland',
			image: '../assets/cars/hyundai-santafe.jpg',
			key_features: ['Spacious interior', 'Comfortable ride'],
			body_styles: [],
			drive_options: ['Front-wheel drive', 'All-wheel drive'],
		},
		{
			name: 'Renault Koleos',
			type: 'Mid-size crossover SUV',
			engine: null,
			variants: [],
			performance: null,
			starting_price: '€33,900 in France (prices vary by location)',
			image: '../assets/cars/renault-koleos.jpg',
			key_features: ['Comfortable ride', 'Spacious interior'],
			body_styles: [],
			drive_options: [],
		},
		{
			name: 'Jeep Rubicon',
			type: 'Off-road SUV',
			engine: 'Multiple options',
			variants: [],
			performance: null,
			starting_price: '$50,000 in the United States',
			image: '../assets/cars/jeep-rubicon.jpg',
			key_features: [
				'Heavy-duty axles',
				'Electronic locking differentials',
				'Rock rails. Designed for extreme off-roading.',
			],
			body_styles: [],
			drive_options: [],
		},
	],
};

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

class FormSelection {
	constructor(carData) {
		this.carData = carData.cars;
		this.getCarNames();
	}

	getCarNames() {
		const selectElement = document.getElementById('car');
		this.carData.forEach(car => {
			const option = document.createElement('option');

			option.value = JSON.stringify(car);

			option.textContent = car.name;
			selectElement.appendChild(option);
		});
	}

	saveCarToLocalStorage() {
		const selectElement = document.getElementById('car');

		const selectedCar = JSON.parse(selectElement.value);

		let storedCars = JSON.parse(localStorage.getItem('selectedCars')) || [];
		storedCars.push(selectedCar);
		localStorage.setItem('selectedCars', JSON.stringify(storedCars));
	}

	validatedForm() {
		const name = document.getElementById('name').value;
		const phone = document.getElementById('phone').value;
		const email = document.getElementById('email').value;
		const car = document.getElementById('car').value;
		const terms = document.getElementById('terms').checked;

		const isNameValid = name.trim() !== '';
		const isPhoneValid = phone.trim() !== '';
		const isEmailValid = email.trim() !== '' && /^\S+@\S+\.\S+$/.test(email);
		const isCarSelected = car !== '';
		const areTermsAccepted = terms;

		return isNameValid && isPhoneValid && isEmailValid && isCarSelected && areTermsAccepted;
	}
}

document.addEventListener('DOMContentLoaded', init);

function init() {
	const carSelection = new FormSelection(carData);

	const form = document.querySelector('.form');
	const message = document.getElementById('message');

	form.addEventListener('submit', event => {
		event.preventDefault();

		if (carSelection.validatedForm()) {
			carSelection.saveCarToLocalStorage();

			form.reset();
			message.textContent = 'Form submitted successfully!';

			setTimeout(() => {
				message.textContent = '';
			}, 5000);
		} else {
			message.textContent = 'Form invalid, try again!';

			setTimeout(() => {
				message.textContent = '';
			}, 5000);
		}
	});
}
