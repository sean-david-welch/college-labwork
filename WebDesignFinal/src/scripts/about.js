// document.addEventListener('DOMContentLoaded', function() {
//   let count = 0;
//
//   const observer = new IntersectionObserver(
//     entries => {
//       entries.forEach(entry => {
//         if (entry.isIntersecting) {
//           setTimeout(() => {
//
//             entry.target.classList.add('timeline-card-visible');
//           }, 200 + (100 * count));
//           count++
//         }
//       });
//     },
//     {
//       threshold: 0.3,
//     }
//   );
//
//   document.querySelectorAll('.timeline-card').forEach(card => {
//     observer.observe(card);
//   });
// });

$(document).ready(function() {
  let count = 0;
  const maxDelay = 1000;

  const observer = new IntersectionObserver(entries => {
    for (let i = 0; i < entries.length; i++) {
      if (entries[i].isIntersecting) {
        const delay = Math.min(200 + (100 * count), maxDelay);
        setTimeout(() => {
          $(entries[i].target).addClass('timeline-card-visible');
        }, delay);
        count++;
      }
    }
  }, {
    threshold: 0.1,
  });

  $('.timeline-card').each(function() {
    observer.observe(this);
  })
})
