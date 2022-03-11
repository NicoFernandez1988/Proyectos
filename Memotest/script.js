let intentos;
let iconos = []
let selecciones = []
let cantidadTarjetas = 32
generarTablero()

function cargarIconos() {
    iconos = [
        '<i class="fa-solid fa-headset"></i>',
        '<i class="fa-solid fa-hat-wizard"></i>',
        '<i class="fa-solid fa-book-skull"></i>',
        '<i class="fa-solid fa-chess-board"></i>',
        '<i class="fa-solid fa-dragon"></i>',
        '<i class="fa-solid fa-dungeon"></i>',
        '<i class="fa-solid fa-gamepad"></i>',
        '<i class="fa-solid fa-ghost"></i>',
        '<i class="fa-solid fa-hand-fist"></i>',
        '<i class="fa-solid fa-heart"></i>',
        '<i class="fa-solid fa-puzzle-piece"></i>',
        '<i class="fa-solid fa-ring"></i>',
        '<i class="fa-solid fa-scroll"></i>',
        '<i class="fa-solid fa-skull-crossbones"></i>',
        '<i class="fa-solid fa-vr-cardboard"></i>',
        '<i class="fa-solid fa-wand-sparkles"></i>',
        
    ]
}

function generarTablero() {
    intentos = 15
    document.getElementById("intentos").innerHTML = "Intentos: " + intentos
    cargarIconos()
    selecciones = []
    let tablero = document.getElementById("tablero")
    let tarjetas = []
    for (let i = 0; i < cantidadTarjetas; i++) {
        tarjetas.push(`
        <div class="area-tarjeta" onclick="seleccionarTarjeta(${i})">
            <div class="tarjeta" id="tarjeta${i}">
                <div class="cara trasera" id="trasera${i}">
                    ${iconos[0]}
                </div>
                <div class="cara superior">
                <i class="fa-solid fa-question"></i>
                </div>
            </div>
        </div>        
        `)
        if (i % 2 == 1) {
            iconos.splice(0, 1)
        }
    }
    tarjetas.sort(() => Math.random() - 0.5)
    tablero.innerHTML = tarjetas.join(" ")
}

function seleccionarTarjeta(i) {
    let tarjeta = document.getElementById("tarjeta" + i)
    if (tarjeta.style.transform != "rotateY(180deg)") {
        tarjeta.style.transform = "rotateY(180deg)"
        selecciones.push(i)
    }
    if (selecciones.length == 2) {
        deseleccionar(selecciones)
        selecciones = []
        
    }
}

function deseleccionar(selecciones) {
    setTimeout(() => {
        let trasera1 = document.getElementById("trasera" + selecciones[0])
        let trasera2 = document.getElementById("trasera" + selecciones[1])
        if (trasera1.innerHTML != trasera2.innerHTML) {
            let tarjeta1 = document.getElementById("tarjeta" + selecciones[0])
            let tarjeta2 = document.getElementById("tarjeta" + selecciones[1])
            tarjeta1.style.transform = "rotateY(0deg)"
            tarjeta2.style.transform = "rotateY(0deg)"
            intentos --;
            document.getElementById("intentos").innerHTML = "Intentos: " + intentos
                
        }else{
            trasera1.style.background = "lightgrey"
            trasera2.style.background = "lightgrey"
            
        }
        if(verificarTriunfo()){
            swal.fire({
                title: '¡Ganaste, Felicitaciones!',
                text: 'Juego finalizado.',
                imageUrl: "https://png.vector.me/files/images/2/5/256664/thumb_up_preview",
                imageWidth: 300,
                imageHeight: 300,
                imageAlt: "Custom image",
                animation: false
            })
        }
        if(verificarDerrota()){
            swal.fire({
                title: '¡Perdiste, Intentalo nuevamente!',
                text: 'Juego finalizado.',
                imageUrl: "https://png.vector.me/files/images/2/5/256660/thumb_down_preview",
                imageWidth: 300,
                imageHeight: 300,
                imageAlt: "Custom image",
                animation: false
            })
            
        }
    }, 1000);
}

    function verificarTriunfo(){
        for(let i = 0; i < cantidadTarjetas; i++){
            let trasera = document.getElementById("trasera" + i)
            if(trasera.style.background != "lightgrey"){
                return false
            }
        }
        return true
    }

    function verificarDerrota(){
        if(intentos >= 0){
            
            return false
        }else{

            generarTablero()


            return true
        }
    }