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
		},
		{
			name: 'Hyundai Creta',
			type: 'Subcompact crossover SUV',
			key_features: ['Fuel efficiency', 'Spacious interior'],
			variants: ['Creta SX 1.6'],
			drive_options: ['Front-wheel drive', 'All-wheel drive'],
			starting_price: 'Around €20,000 in Ireland',
		},
		{
			name: 'Mercedes-AMG GT',
			type: 'Luxury grand tourer sports car',
			engine: 'Twin-turbocharged V8',
			body_styles: ['Coupe', 'Roadster'],
			features: ['Electronically controlled suspension', 'Limited-slip differential'],
			starting_price: 'Around €185,570 in Ireland',
		},
		{
			name: 'Range Rover Evoque',
			type: 'Luxury SUV',
			key_features: ['Stylish design', 'Off-road capability'],
			starting_price: 'From €66,270 in Ireland',
			drive_options: ['Front-wheel drive', 'All-wheel drive'],
		},
		{
			name: 'BMW 3 Series Gran Turismo',
			type: 'Four-door liftback',
			key_features: ['Sporty handling', 'Spacious cargo area'],
			starting_price: 'Approximately £35,629',
		},
		{
			name: 'Audi A5 Sportback',
			type: 'Stylish and sporty car',
			starting_price: 'Around $41,400',
			drive_options: ['Front-wheel drive', 'All-wheel drive'],
			key_features: ['Comfortable interior'],
		},
		{
			name: 'Mercedes-Benz A-Class',
			type: 'Luxurious compact car',
			starting_price: 'About €32,100 in Ireland',
			drive_options: ['Front-wheel drive', 'All-wheel drive'],
		},
		{
			name: 'Maserati GranTurismo',
			type: 'Luxury sports car',
			engine: 'V8',
			key_features: ['Stylish design'],
			starting_price: 'Around $148,885',
		},
		{
			name: 'Ford Focus',
			type: 'Compact car',
			body_styles: ['Sedan', 'Hatchback'],
			key_features: ['Affordability', 'Fuel efficiency'],
			starting_price: 'Used models starting around €10,000 in Ireland',
		},
		{
			name: 'Alfa Romeo 4C',
			type: 'Lightweight two-door sports car',
			engine: 'Mid-engine turbocharged',
			starting_price: 'Around €30,000 used',
			key_features: ['Powerful engine'],
		},
		{
			name: 'Hyundai Santa Fe',
			type: 'Mid-size SUV',
			drive_options: ['Front-wheel drive', 'All-wheel drive'],
			key_features: ['Spacious interior', 'Comfortable ride'],
			starting_price: 'Used models starting at €25,000 in Ireland',
		},
		{
			name: 'Renault Koleos',
			type: 'Mid-size crossover SUV',
			starting_price: '€33,900 in France (prices vary by location)',
			key_features: ['Comfortable ride', 'Spacious interior'],
		},
		{
			name: 'Jeep Rubicon',
			type: 'Off-road SUV',
			model: 'Part of the Jeep Wrangler lineup',
			key_features: [
				'Heavy-duty axles',
				'Electronic locking differentials',
				'Rock rails. Designed for extreme off-roading.',
			],
			engine_options: ['Turbocharged four-cylinder', 'V6', 'Diesel V6'],
			special_editions:
				'Various special editions and packages available, enhancing its off-road capability and comfort.',
			starting_price: '$50,000 in the United States',
		},
	],
};

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
}

document.addEventListener('DOMContentLoaded', init);

function init() {
	const carSelection = new FormSelection(carData);

	const form = document.querySelector('.form');
	const message = document.getElementById('message');

	form.addEventListener('submit', event => {
		event.preventDefault();
		carSelection.saveCarToLocalStorage();

		form.reset();
		message.textContent = 'Form submitted successfully!';

		setTimeout(() => {
			message.textContent = '';
		}, 5000);
	});
}
