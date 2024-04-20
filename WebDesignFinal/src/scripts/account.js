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
}

document.addEventListener('DOMContentLoaded', init);

function init() {
	const accountPage = new AccountPage();
}
