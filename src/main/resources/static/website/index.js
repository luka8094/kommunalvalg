console.log("så er det hul igennem, du!")

const getAllKandidaterButton = document.getElementById("all-kandiater")
const root = document.getElementsByClassName("root")[0]

getAllKandidaterButton.onclick = getAllKandidater

function getAllKandidater() {

    console.log("button was clicked")
    fetch("http://localhost:8080/kandidater")
        .then(res => res.json())
        .then( res => {
            let arr = JSON.stringify(res).split(/[,]/g)
            console.log(arr)
        })

}