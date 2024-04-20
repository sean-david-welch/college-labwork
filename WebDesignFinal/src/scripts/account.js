class AccountPage {
	constructor() {
		this.randomisedCars = this.getCarsFromLocalStorage('randomisedCars');
		this.selectedCars = this.getCarsFromLocalStorage('selectedCars');
	}

	getCarsFromLocalStorage(key) {
		const carsJSON = localStorage.getItem(key);

		if (carsJSON) {
			return JSON.parse(carsJSON);
		}

		return [];
	}

	displaySubheading() {
		const container = document.getElementById('subheadingContainer');
		if (this.selectedCars.length > 0 || this.randomisedCars.length > 0) {
			container.innerHTML = `<h2 class="subheading">Here's your account information</h2>`;
		} else {
			container.innerHTML = `<h2 class="subheading">No information available please use the randomiser or the form and come back</h2>`;
		}
	}

	displaySelectedCars() {
		if (this.selectedCars.length > 0) {
			const container = document.getElementById('selectedCarsContainer');
			const carsHtml = this.selectedCars
				.map(
					(car, index) => `<div class="car-card">
                        <h2 class="subheading">${car.name}</h2>
                        <p class="subheading">Starting price: ${car.starting_price}</p>
                        <img src="${car.image}" alt="${car.name}">
                        <button class="btn delete-car" data-index="${index}" data-key="selectedCars">Delete Car<i class="fa-solid fa-trash"></i></button>
                    </div>`
				)
				.join('');
			const clearButtonHtml = `<button class="btn trash-button" data-key="selectedCars">Clear Selection<i class="fa-solid fa-trash"></i></button>`;
			container.innerHTML = `<h1 class="section-heading">Selected Cars</h1>${clearButtonHtml}${carsHtml}`;
			this.attachClearEventListeners();
			this.attachDeleteEventListeners();
		}
	}

	displayRandomCars() {
		if (this.randomisedCars.length > 0) {
			const container = document.getElementById('randomisedCarsContainer');
			const carsHtml = this.randomisedCars
				.map(
					(car, index) => `<div class="car-card">
                        <h2 class="subheading">${car.name}</h2>
                        <p class="subheading">Starting price: ${car.starting_price}</p>
                        <img src="${car.image}" alt="${car.name}">
                        <button class="btn delete-car" data-index="${index}" data-key="randomisedCars">Delete Car<i class="fa-solid fa-trash"></i></button>
                    </div>`
				)
				.join('');
			const clearButtonHtml = `<button class="btn trash-button" data-key="randomisedCars">Clear Results<i class="fa-solid fa-trash"></i></button>`;
			container.innerHTML = `<h1 class="section-heading">Randomized Results</h1>${clearButtonHtml}${carsHtml}`;
			this.attachClearEventListeners();
			this.attachDeleteEventListeners();
		}
	}

	clearLocalStorageByKey(key) {
		localStorage.removeItem(key);
		window.location.reload();
	}

	deleteCarFromLocalStorage(key, index) {
		let cars = this.getCarsFromLocalStorage(key);

		cars.splice(index, 1);
		localStorage.setItem(key, JSON.stringify(cars));

		window.location.reload();
	}

	attachDeleteEventListeners() {
		document.querySelectorAll('.delete-car').forEach(button => {
			button.addEventListener('click', event => {
				const key = event.target.getAttribute('data-key');
				const index = event.target.getAttribute('data-index');
				this.deleteCarFromLocalStorage(key, parseInt(index));
			});
		});
	}

	attachClearEventListeners() {
		document.querySelectorAll('.trash-button').forEach(button => {
			button.removeEventListener('click', this.handleClearButtonClick);
			button.addEventListener('click', this.handleClearButtonClick.bind(this));
		});
	}

	handleClearButtonClick(event) {
		const key = event.target.getAttribute('data-key');
		this.clearLocalStorageByKey(key);
	}
}

document.addEventListener('DOMContentLoaded', init);

function init() {
	const accountPage = new AccountPage();
	accountPage.displayRandomCars();
	accountPage.displaySelectedCars();
	accountPage.displaySubheading();
}
