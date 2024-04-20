class TypeWriter {
	constructor(txtElement, words, wait = 3000) {
		this.txtElement = $(txtElement);
		this.words = words;
		this.txt = '';
		this.wordIndex = 0;
		this.wait = parseInt(wait, 10);
		this.type();
		this.isDeleting = false;
	}

	type() {
		const current = this.wordIndex % this.words.length;
		const fullTxt = this.words[current];

		if (this.isDeleting) {
			this.txt = fullTxt.substring(0, this.txt.length - 1);
		} else {
			this.txt = fullTxt.substring(0, this.txt.length + 1);
		}

		this.txtElement.html(`<span class="txt">${this.txt}</span>`);
		let typeSpeed = 75;

		if (this.isDeleting) {
			typeSpeed /= 2;
		}

		if (!this.isDeleting && this.txt === fullTxt) {
			typeSpeed = this.wait;
			this.isDeleting = true;
		} else if (this.isDeleting && this.txt === '') {
			this.isDeleting = false;
			this.wordIndex++;
			typeSpeed = 200;
		}

		setTimeout(() => this.type(), typeSpeed);
	}
}

// Jquery implementation
$(document).ready(function () {
	const txtElement = $('.txt-type');
	const words = JSON.parse(txtElement.attr('data-words'));
	const wait = txtElement.attr('data-wait');
	new TypeWriter(txtElement, words, wait);
});
