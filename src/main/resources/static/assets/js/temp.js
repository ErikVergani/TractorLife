const weatherMap = new Map();

window.addEventListener("load", (event) => {
    getTemp();
});

function getTemp()
{
    ( async function(){
        const response = await  fetch('http://localhost:8080/temp');
        const data = await response.json();

        document.getElementById('city').innerText = data.results.city;
        document.getElementById('temp').innerText = data.results.temp;
        document.getElementById('description').innerText = data.results.description;
        document.getElementById('sunrise').innerText = data.results.sunrise;
        document.getElementById('sunset').innerText = data.results.sunset;
        document.getElementById('wind_speedy').innerText = data.results.wind_speedy;
        document.getElementById('image').src = 'http://assets.api.hgbrasil.com/weather/images/' + data.results.condition_code + '.png';
    })()
}

