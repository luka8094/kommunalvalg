console.log("så er det hul igennem, du!")

const getAllKandidaterButton = document.getElementById("all-kandiater")
let kandidatListElement = document.getElementsByClassName("kandidat-list")[0]

getAllKandidaterButton.onclick = getAllKandidater

function localKandidaterCache(){
    let kandidaterArray = []

    return{

        addKandidat : (kandidat) => kandidaterArray.push(kandidat),

        getAllKandidater : () => kandidaterArray,

        findByParti : (partiInitialer) => kandidaterArray.find( kandidat => kandidat.parti.initialer == partiInitialer)

    }
}

let kandidaterCache = localKandidaterCache()

function getAllKandidater() {

    console.log("button was clicked")
    fetch("http://localhost:8080/kandidater")
        .then(response => response.json())
        .then( response => {
            JSONdataIterator(response)
            refreshKanidatList()
        })
}

function JSONdataIterator(json){
    //let temporaryArray = []
    for(key in json){
        //temporaryArray.push(json[key])
        kandidaterCache.addKandidat(json[key])
    }
    //temporaryArray.forEach( e => console.log(e.navn))
    //console.log(kandidaterCache.findByParti("A"))
}

function refreshKanidatList(){

    let kandidatRows = []
    let kandidatData = kandidaterCache.getAllKandidater()

    kandidatData.forEach( kandidat =>

        kandidatRows.push(`<div class="kandiat-row">
                <div class="kandidat-navn">${kandidat.navn}</div>
                <div class="kandidat-parti">${kandidat.parti.intitialer}</div>
                </div>`)
    )

    kandidatRows.join(",")
    console.log(kandidatRows)

    kandidatListElement.innerHTML = kandidatRows.toString();

}