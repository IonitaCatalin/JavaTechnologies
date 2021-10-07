const axios = require('axios').default;

const invoke = async function (mock,sync,key,value) {

    const url = `http://localhost:8080/servlet?mock=${mock}&sync=${sync}&key=${key}&value=${value}`;

    axios.get(url)
        .then(response => {
            console.log(response.data);
        })
        .catch(err => {
            console.log(err);
        })
}

const benchmark = function(mock,sync,key,value,times) {
    console.time(`Running benchmark with #${times} requests [Sync:${sync}].`);

    let requests = [];
    let url = `http://localhost:8080/servlet?mock=${mock}&sync=${sync}&key=${key}&value=${value}`;

    for(let i = 0; i < times; ++i) {
        let request = axios.get(url);
        requests.push(request);
    }

    axios.all(requests).then(() => {
        console.timeEnd(`Running benchmark with #${times} requests [Sync:${sync}].`);
        console.log('\n');
    }).catch(err => {
        console.log(err);
    })
}

var argv = process.argv;

if(argv.length < 7) {
    console.log('USAGE app [mode: invoke,benchmark] [mock: boolean] [sync: boolean] [key: integer] [value: string] [benchmark-with: integer]');
    process.exit();
}

var mock = argv[3];
var sync = argv[4];
var key = argv[5]
var value = argv[6];
var times = argv[7];

if(!['invoke','benchmark'].includes(argv[2])) {
    console.log('Unknown mode of utilization. Should be either <invoke> or <benchmark>.');
    process.exit();
} else {
    let url = `http://localhost:8080/servlet?mock=${mock}&sync=${sync}&key=${key}&value=${value}`;
    if(argv[2] === 'invoke') {
        invoke(mock,sync,key,value);
    } 
    if(argv[2] === 'benchmark') {
        console.log(`\nMock:${mock}\nSync:${sync}\nKey:${key}\nValue:${value}\n`)
        benchmark(mock,sync,key,value,times);
    }
}



