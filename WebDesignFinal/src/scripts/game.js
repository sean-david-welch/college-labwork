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
