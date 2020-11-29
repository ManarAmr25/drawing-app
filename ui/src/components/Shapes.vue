<template>

  <button id="line" title="Line" v-on:click="line"> <svg height="100" width="100">
    <line x1="0" y1="0" x2="100" y2="100" style="stroke:rgb(33,151,190);stroke-width:2" />
  </svg></button>
  <button id="square" title="Square" v-on:click="square(100,'s')"> </button>
  <button id="rectangle" title="Rectangle" v-on:click="square(150,'r')"> </button>
  <button id="triangle" title="Triangle" v-on:click="triangle"></button>
  <button id="ellipse" title="Ellipse" v-on:click="ellipse"> </button>
  <button id="circle" title="Circle" v-on:click="circle"> </button>

  <br>

</template>

<script>
import $ from 'jquery'
var list =[];
 function shape(x,y,w,h,fcolor,border,borderwidth,bordercolor,t){
   this.x=x;
   this.y=y;
   this.w=w;
   this.h=h;
   this.fcolor=fcolor;
   this.border=border;
   this.borderwidth=borderwidth;
   this.bordercolor=bordercolor;
   this.t=t;
 }
 //detect selection
function init() {
  $('#myCanvas').click(function(e){
    const canvas = document.getElementById('myCanvas');
    var len = canvas.getBoundingClientRect();
    var x=e.clientX-len.x, y=e.clientY-len.y;
    if(list.length>0) {
      var c= list[0];

      const ctx = canvas.getContext('2d');
      ctx.rect(c.x, c.y, c.w, c.h);
      ctx.fill();
        console.log("x: "+x+"  y: "+y +" val: "+ctx.isPointInPath(x,y));
        console.log("mx: "+e.clientX +"  my: "+e.clientY )
        if(ctx.isPointInPath(x,y)){
          //code to select and show box

        }

    }
  })
}


 $(document).ready(function() {
   init();
 });

export default {
  name: "Shapes",
  data(){
    return({

    })
  },
  methods:{
      line(){
        var x = new shape(500,200,700,400,'blue',false,0,null,'l');
        list.push(x);
        var canvas = document.getElementById('myCanvas');
        if (canvas.getContext) {
          var ctx = canvas.getContext('2d');
          ctx.beginPath();
          ctx.moveTo(500, 200);
          ctx.lineTo(700, 400);
          ctx.strokeWidth=7;
          ctx.strokeStyle='blue'
          ctx.stroke();
        }
      },
    square(width,t){
        var x = new shape(500,200,width,100,'blue',false,0,null,t);
        list.push(x);
        console.log(list[0])
      var canvas = document.getElementById('myCanvas');
        if(canvas.getContext) {
          var ctx = canvas.getContext("2d");
          ctx.fillStyle = 'blue'
          ctx.fillRect(500, 200, width, 100)
        }

    },
    triangle(){
      var x = new shape(500,200,200,200,'blue',false,0,null,'t');
      list.push(x);
      var canvas = document.getElementById('myCanvas');
      if (canvas.getContext) {
        var ctx = canvas.getContext('2d');
        // triangle 4, at right, top
        ctx.beginPath();
        ctx.strokeStyle = "#00F";
        ctx.moveTo(500, 200); // pick up "pen," reposition at 500 (horiz), 0 (vert)
        ctx.lineTo(400, 400); // draw straight down by 200px (200 + 200)
        ctx.lineTo(600, 400); // draw up toward left (100 less than 300, so left)
        ctx.closePath(); // connect end to start
        ctx.fillStyle='blue'
        ctx.fill();
      }
    },
    ellipse(){
        //w radius x      h radius y
      var x = new shape(500,200,80,50,'blue',false,0,null,'e');
      list.push(x);
      var canvas = document.getElementById('myCanvas');
      if (canvas.getContext) {
        var ctx = canvas.getContext('2d');
        ctx.beginPath();
        ctx.ellipse(500, 200, 80, 50, 0, 0, 2 * Math.PI);
        ctx.fillStyle='blue'
        ctx.fill();

      }
    },
    circle(){
        //w = radius     h=start angle
      var x = new shape(500,200,100,0,'blue',false,0,null,'c');
      list.push(x);
      var canvas = document.getElementById('myCanvas');
      if (canvas.getContext) {
        var ctx = canvas.getContext('2d');
        ctx.beginPath();
        ctx.arc(500, 200, 100, 0, 2 * Math.PI);
        ctx.fillStyle='blue'
        ctx.fill();

      }

    },
   m(){
      alert("okey")
    }

    }
}
</script>

<style scoped>

button{

  width: 100px;
  height: 100px;
  padding: 0;
  border: none;
  background: #2197be;
  margin-top: 15px;
  margin-left: 30px;
  margin-bottom: 50px;
  display: block;
}
#rectangle{
  margin-left: 20px;
  width: 125px;
}
button:hover{
  cursor: grab;
}
#triangle{
  width: 0;
  height: 0;
  background: none;
  border-left: 50px solid transparent;
  border-right: 50px solid transparent;
  border-bottom: 100px solid #2197be;
}
#circle{
  border-radius:100%;
}
#ellipse{
  border-radius: 50%;
  width: 125px;
  height: 90px;
  margin-left: 20px;
}
#line{
  background: none;
  width: 100px;
  height: 100px;
}
</style>