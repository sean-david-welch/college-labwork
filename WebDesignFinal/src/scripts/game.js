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
			name: 'Hyundai Creta',
			type: 'Subcompact crossover SUV',
			engine: null,
			variants: ['Creta SX 1.6'],
			performance: null,
			starting_price: 'Around €20,000 in Ireland',
			image: '../assets/cars/hyundai-creta.jpg',
			key_features: ['Fuel efficiency', 'Spacious interior'],
			body_styles: [],
			drive_options: ['Front-wheel drive', 'All-wheel drive'],
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

class CarRandomizer {
	constructor(carData) {
		this.carData = carData.cars;
		this.dialog = document.getElementById('d');
	}

	getRandomCar() {
		const randomIndex = Math.floor(Math.random() * this.carData.length);
		return this.carData[randomIndex];
	}

	play() {
		const selectedCar = this.getRandomCar();
		this.dialog.innerHTML = `
			<div class="car-info">
				<h1 class="section-heading">${selectedCar.name} - ${selectedCar.starting_price}</h1>
				<img src="${selectedCar.image}" alt="car-image">
				<a class="btn" onclick="d.close()">Close</a>
			</div>
		`;
		setTimeout(() => {
			this.dialog.showModal();
		}, 50);
		this.saveCarToLocalStorage(selectedCar);
	}

	saveCarToLocalStorage(selectedCar) {
		let storedCars = JSON.parse(localStorage.getItem('randomisedCars')) || [];
		storedCars.push(selectedCar);
		localStorage.setItem('randomisedCars', JSON.stringify(storedCars));
	}
}

document.addEventListener('DOMContentLoaded', init);

function init() {
	const carRandomizer = new CarRandomizer(carData);
	const btn = document.getElementById('dialog-button');

	btn.onclick = () => carRandomizer.play();
}
