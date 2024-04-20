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
