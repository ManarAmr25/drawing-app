import { createApp } from 'vue'
import App from './App.vue'
createApp(App).mount('#app')
//import axios from 'axios'
export const recreate = {
    draw() {

        var canvas = document.getElementById('myCanvas');
        if (canvas.getContext) {
            var context = canvas.getContext('2d');
            context.canvas.width = 1320;
            context.canvas.height = 600;

            for (var x = 0; x < canvas.width; x += 50) {
                context.moveTo(x, 0);
                context.lineTo(x, canvas.height);

            }

            for (var y = 0; y < canvas.height; y += 50) {
                context.moveTo(0, y);
                context.lineTo(canvas.width, y);

            }
            context.lineWidth = 0.9;
            context.strokeStyle = '#c9c7c7';
            context.stroke();


        }
    },
}

//calculate coordinates
export const fun = {
    show(event) {
        var canvas = document.getElementById('myCanvas');
        var len = canvas.getBoundingClientRect();
        var x = event.pageX - len.left + 2;
        var y = event.pageY - len.top + 1;
        //console.log(Math.floor(x));
        //console.log(Math.floor(y));
        return "X : " + Math.floor(x) + "     Y: " + Math.floor(y);
    }
};

recreate.draw();
window.onclick = function (event) {
    if (event.target == document.getElementById("myModal")) {
        document.getElementById("myModal").style.display = "none";
    }
    if (event.target == document.getElementById("myModal2")) {
        document.getElementById("myModal2").style.display = "none";
    }
    if (event.target == document.getElementById("myModal1")) {
        document.getElementById("myModal1").style.display = "none";
    }
}