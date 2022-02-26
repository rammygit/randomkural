var btn = document.querySelector('#clickbtn');
var contentdiv = document.querySelector('#contentdiv');

btn.addEventListener('click', function (event) {
	console.log(event); // The event details
	console.log(event.target); // The clicked element

    // fetch('https://randomkural.herokuapp.com/thirukural/0')
    fetch('http://localhost:8081/thirukural/0')
    .then(response => response.json())
    .then(data => {
        console.log(data)
        contentdiv.innerHTML = `<p><h3>${data.sect_tam}</h3></p>
                                <p>${data.line1}</p>
                                <p>${data.line2}</p>
                                <p><h3>Meaning</h3></p>
                                <p>${data.tam_exp}</p>
                                <p>${data.eng_exp}</p>`
    })
    .catch(error =>
        // A Error occured
        console.log(error)
      )
});


