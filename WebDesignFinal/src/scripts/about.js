document.addEventListener('DOMContentLoaded', function () {
	const observer = new IntersectionObserver(
		entries => {
			entries.forEach(entry => {
				if (entry.isIntersecting) {
					entry.target.classList.add('timeline-card-visible');
				}
			});
		},
		{
			threshold: 1,
		}
	);

	document.querySelectorAll('.timeline-card').forEach(card => {
		observer.observe(card);
	});
});
