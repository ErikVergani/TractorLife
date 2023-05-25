window.addEventListener("load", (event) => {

    let values;

    const Http = new XMLHttpRequest();
    Http.open("GET", '/api/os/getChartData' );

    Http.send();

    Http.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            values = JSON.parse(Http.responseText);


            const ctx = document.getElementById('myChart');
            Chart.defaults.color = '#000';
            new Chart(ctx, {
                type: 'bar',
                scales: {
                    height: 650
                },
                data: {
                    labels: ['Ordens Abertas', 'Ordens Encerradas'],
                    datasets: [{
                        label: '# de ordens',
                        data: values,
                        borderWidth: 1,
                        backgroundColor:[
                            'rgba(54,162,235,0.6)',
                            'rgba(255,99,132,0.6)'

                        ]
                    }],
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    },
                    plugins: {
                        legend: {
                            labels: {
                                font: {
                                    size: 25
                                }
                            }
                        }
                    }
                }
            });
        }
    }
});
