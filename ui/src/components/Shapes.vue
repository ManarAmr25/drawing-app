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
  <div id="model" class="modalsh">
    <div class="content">
      <button id="close" v-on:click="redraw(false,1)">&times;</button>
      <button id="del" v-on:click="deletes()"> delete</button>
      <button id="copy" v-on:click="copy()"> copy</button>
      <br>
      <div id="co"> customize the copied shape</div>
      <div id="main">
      <label for="fillcolor">fill-color</label>
      <input id="fillcolor" type="color">
        <br>
      <label for="borderwidth">border-width</label>
      <input id="borderwidth" type="number" min="0">
      &nbsp;&nbsp;
      <label for="bordercolor">border color</label>
      <input id="bordercolor" type="color">
      <br>
      </div>
      <div id="lmode">
        <label for="lcolor">color</label>
        <input id="lcolor" type="color">
        <br>
        <label for="lwidth">width</label>
        <input id="lwidth" type="number" min="0">
      </div>
      <div id="mode0">
        <span> top-left coordinates of shape</span>
        <br>
        &nbsp;&nbsp;&nbsp;
      <label for="x">x</label>
      &nbsp;
      <input id="x" type="number" min="0">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <label for="y"> y</label>
      &nbsp;&nbsp;
      <input id="y" type="number" min="0">
      <br>
      </div>
      <div id="mode">
      <label for="wid">width</label>
      <input id="wid" type="number" min="0">
      &nbsp;&nbsp;&nbsp;
      <label for="height">height</label>
      <input id="height" type="number" min="0">
      </div>
      <!-- for triangle and line -->
      <div id="mode1">
      <br>
      <label for="p1"> first point</label>
        <br>
        <div id="p1">
          <label for="p1x">x1</label>
      <input id="p1x" type="number"  min="0">
          <label for="p1y">y1</label>
        <input id="p1y" type="number"  min="0">
        </div>
        <br>
      <label for="p2"> second point</label>
        <br>
        <div id="p2">
          <label for="p2x">x2</label>
            <input id="p2x" type="number"  min="0">
          <label for="p2y">y2</label>
              <input id="p2y" type="number"  min="0">
        </div>

      </div>

      <div id="tmode">
        <br>
      <label for="p3"> third point</label>
        <br>
        <div id="p3">
          <label for="p3x">x3</label>
            <input id="p3x" type="number"  min="0">
          <label for="p3y">y3</label>
              <input id="p3y" type="number"  min="0">
        </div>
        <br>
      </div>
      <!--  for circle -->
      <div id="mode2">
      <label for="rad">radius</label>
      <input id="rad" type="number" min="0">
      </div>

      <!--  for ellipse -->
      <div id="mode3">
      <label for="radx">x-radius</label>
      <input id="radx" type="number" min="0">
        &nbsp;&nbsp;
      <label for="rady">y-radius</label>
      <input id="rady" type="number" min="0">
      </div>
      <br>
      <button id="ok" v-on:click="redraw(true,1)">ok</button>
      <button id="ok2" v-on:click="redraw(true,2)">ok</button>
    </div>
  </div>

</template>

<script>
import $ from 'jquery'
import sh from '@/components/Shapes'
import {recreate} from "@/main";
import * as axios from "core-js";

var list =[];
var mapping=new Map(); // key =id,value = index
var sel=false;
var selShape=null;
function shape(x,y,w,h,x1,y1,x2,y2,x3,y3,fcolor,border,borderwidth,bordercolor,t){
  this.x=x;
  this.y=y;
  this.w=w;
  this.h=h;

  //triangle
  this.x1=x1;
  this.y1=y1;
  this.x2=x2;
  this.y2=y2;
  this.x3=x3;
  this.y3=y3;

  this.fcolor=fcolor;
  this.border=border;
  this.borderwidth=borderwidth;
  this.bordercolor=bordercolor;
  this.t=t;
  this.id;
}
//detect selection
function init() {
  $('#myCanvas').click(function(e){
    var temp = document.createElement('canvas');
    var canvas=document.getElementById('myCanvas');
    var len = canvas.getBoundingClientRect();
    var x=e.clientX-len.x, y=e.clientY-len.y;

    if(list.length>0) {
      for(var i=0;i<list.length;i++) {
        var c = list[i];
        sh.methods.drawing(c,temp, true);
        const ctx = temp.getContext('2d');
        console.log("x: " + x + "  y: " + y + " val: " + ctx.isPointInPath(x, y));
        console.log("mx: " + e.clientX + "  my: " + e.clientY)
        if(c.t=='l'){
          var slope = (c.y-c.h)/(c.x-c.w);
          var b = c.y-slope*c.x;
          console.log("right = "+(slope*x+b));
          if(c.x==c.w){
            if(Math.abs(c.x-x)<=10&&y>=c.y&&c.y<=c.h){
              sel = true;
              create_layout(i);
              break;
            }
          }
          else if(Math.abs(y-(slope*x+b))<=20){
            sel = true;
            create_layout(i);
            break;
          }
        }
        else if (ctx.isPointInPath(x, y)&&!sel) {
            sel=true;
            create_layout(i);
            break;
        }
      }
    }
  })
}


$(document).ready(function() {
  init();
});

function create_layout(n){
  selShape=list[n];
  var canvas = document.getElementById('myCanvas');
  if (canvas.getContext) {
    var context=canvas.getContext('2d');
    sh.methods.drawing(selShape,canvas)
    context.setLineDash([20, 15]);
    context.lineWidth = 5;
    context.strokeStyle='red'
    if(selShape.t=='r'||selShape.t=='s'){
      context.strokeRect(selShape.x,selShape.y, selShape.w,selShape.h);
    }
    else{
      context.stroke();
    }

  }
    showoptions();
}
function showoptions() {
  //show options
  document.getElementById("model").style.display = "block";
  document.getElementById("fillcolor").value = selShape.fcolor;
  document.getElementById('borderwidth').value=selShape.borderwidth;
  if(selShape.bordercolor!=null){
    document.getElementById('bordercolor').value=selShape.bordercolor;
  }
  if(selShape.t=="t"||selShape.t=='l'){

    document.getElementById("mode1").style.display = "block";
    if(selShape.t=='l'){
      document.getElementById('main').style.display="none";
      document.getElementById('lmode').style.display="block";

      document.getElementById("lcolor").value = selShape.fcolor;
      document.getElementById('lwidth').value=selShape.borderwidth;
    }
    if(selShape.t=="t"){
      document.getElementById("tmode").style.display = "block";
      document.getElementById('p1x').value=selShape.x1;
      document.getElementById('p1y').value=selShape.y1;
      document.getElementById('p2x').value=selShape.x2;
      document.getElementById('p2y').value=selShape.y2;
      document.getElementById('p3x').value=selShape.x3;
      document.getElementById('p3y').value=selShape.y3;
    }
    else{
      document.getElementById('p1x').value=selShape.x;
      document.getElementById('p1y').value=selShape.y;
      document.getElementById('p2x').value=selShape.w;
      document.getElementById('p2y').value=selShape.h;
    }
  }
  else if(selShape.t=='c'){
    document.getElementById("mode0").style.display = "block";
    document.getElementById("mode2").style.display = "block";
    document.getElementById('x').value=selShape.x;
    document.getElementById('y').value=selShape.y;
    document.getElementById('rad').value=selShape.w;

  }
  else if(selShape.t=='s'||selShape.t=='r'){
    document.getElementById("mode0").style.display = "block";
    document.getElementById("mode").style.display = "block";
    document.getElementById('x').value=selShape.x;
    document.getElementById('y').value=selShape.y;
    document.getElementById('wid').value=selShape.w;
    document.getElementById('height').value=selShape.h;
  }
  else{
    document.getElementById("mode0").style.display = "block";
    document.getElementById("mode3").style.display = "block";
    document.getElementById('x').value=selShape.x;
    document.getElementById('y').value=selShape.y;
    document.getElementById('radx').value=selShape.w;
    document.getElementById('rady').value=selShape.h;
  }
}


export default {
  name: "Shapes",
  data(){
    return({

    })
  },
  methods:{
    line(){
    var x = new shape(500,200,700,400,0,0,0,0,0,0,'#0000ff',false,7,null,'l');
    var index = list.length;
    list.push(x);
      axios.get("http://localhost:8085/create", {
        params: {
          type:"line"
        }
      })
          .then(function (response) {
              mapping.set(response,index)
            list[index].id=response;
          })
    var canvas = document.getElementById('myCanvas');
    this.drawing(x,canvas,true);
    },
    square(width,t){
        var x = new shape(500,200,width,100,0,0,0,0,0,0,'#0000ff',false,0,null,t);
        var index = list.length;
        var type ;
        if(t=='s'){
          type="square"
        }
        else{
          type="rectangle"
        }
        list.push(x);
        axios.get("http://localhost:8085/create", {
          params: {
            type:type
          }
        })
            .then(function (response) {
              mapping.set(response,index)
              list[index].id=response;
            })
      var canvas = document.getElementById('myCanvas');
      this.drawing(x,canvas,true);

    },
    triangle(){
      var x = new shape(0,0,0,0,500,200,400,400,600,400,'#0000ff',false,0,null,'t');
      var index = list.length;
      list.push(x);
      axios.get("http://localhost:8085/create", {
        params: { 
          type:"triangle"
        }
      })
          .then(function (response) {
            mapping.set(response,index)
            list[index].id=response;
          })
      var canvas = document.getElementById('myCanvas');
      this.drawing(x,canvas,true);
    },
    ellipse(){
        //w radius x      h radius y
      var x = new shape(500,200,80,50,0,0,0,0,0,0,'#0000ff',false,0,null,'e');
      var index = list.length;
      list.push(x);
      axios.get("http://localhost:8085/create", {
        params: {
          type:"ellipse"
        }
      })
          .then(function (response) {
            mapping.set(response,index)
            list[index].id=response;
          })
      var canvas = document.getElementById('myCanvas');
      this.drawing(x,canvas,true);
    },
    circle(){
        //w = radius     h=start angle
      var x = new shape(500,200,100,0,0,0,0,0,0,0,'#0000ff',false,0,null,'c');
      var index = list.length;
      list.push(x);
      axios.get("http://localhost:8085/create", {
        params: {
          type:"circle"
        }
      })
          .then(function (response) {
            mapping.set(response,index)
            list[index].id=response;
          })
      var canvas = document.getElementById('myCanvas');
      this.drawing(x,canvas,true);

    },
    drawing(shape , can , flag){
      if (can.getContext) {
        var ctx = can.getContext('2d');
        if(shape.t=='l'){ //draw line
          ctx.beginPath();
          ctx.moveTo(shape.x, shape.y);
          ctx.lineTo(shape.w, shape.h);
          ctx.strokeWidth=shape.borderwidth;
          ctx.strokeStyle=shape.fcolor;
          ctx.stroke();
        }
      else if(shape.t=='s'||shape.t=="r"){ //draw rectangle or square
          ctx.fillStyle = shape.fcolor
          ctx.rect(shape.x, shape.y, shape.w, shape.h)
          if(shape.border){
            ctx.strokeStyle=shape.bordercolor;
            ctx.lineWidth=shape.borderwidth;
            ctx.strokeRect(shape.x,shape.y,shape.w,shape.h);
          }
        }
      else if(shape.t=='t'){
          ctx.beginPath();
          ctx.moveTo(shape.x1, shape.y1);
          ctx.lineTo(shape.x2, shape.y2);
          ctx.lineTo(shape.x3, shape.y3);
          ctx.closePath(); // connect end to start
          ctx.fillStyle=shape.fcolor
          if(shape.border){
            ctx.strokeStyle=shape.bordercolor;
            ctx.lineWidth=shape.borderwidth;
            ctx.stroke();
          }
        }
      else if(shape.t=='c'){ //draw circle
          ctx.beginPath();
          ctx.arc(shape.x, shape.y, shape.w, shape.h, 2 * Math.PI);
          ctx.fillStyle=shape.fcolor;
          if(shape.border){
            ctx.strokeStyle=shape.bordercolor;
            ctx.lineWidth=shape.borderwidth;
            ctx.stroke();
          }
        }
      else{ //draw ellipse
          ctx.beginPath();
          ctx.ellipse(shape.x, shape.y, shape.w, shape.h, 0, 0, 2 * Math.PI);
          ctx.fillStyle=shape.fcolor;
          if(shape.border){
            ctx.strokeStyle=shape.bordercolor;
            ctx.lineWidth=shape.borderwidth;
            ctx.stroke();
          }
        }
      if(flag){
        ctx.fill();
      }

      }

    },
   redraw(flag,n){
     document.getElementById("model").style.display = "none";
      if(flag){
        var m = new Map()
        var type;
        selShape.fcolor=document.getElementById('fillcolor').value;
        selShape.borderwidth=document.getElementById('borderwidth').value;
        selShape.bordercolor=document.getElementById('bordercolor').value;
        m.set("fillcolor",selShape.fcolor);
        m.set("borderwidth",selShape.borderwidth);
        m.set("bordercolor",selShape.bordercolor);
        if(selShape.borderwidth>0){
          selShape.border=true
        }
        if(selShape.t=="l"){
          type="line"
          selShape.x=document.getElementById('p1x').value;
          selShape.y=document.getElementById('p1y').value;
          selShape.w=document.getElementById('p2x').value;
          selShape.h=document.getElementById('p2y').value;
          m.set("first",(selShape.x,selShape.y))
          m.set("second",(selShape.w,selShape.h))
        }
        else if(selShape.t=='s'||selShape.t=='r'){
          if(selShape.t=='s'){
            type="square"
          }
          else{
            type="rectangle"
          }
          selShape.x=document.getElementById('x').value;
          selShape.y=document.getElementById('y').value;
          selShape.w=document.getElementById('wid').value;
          selShape.h=document.getElementById('height').value;
          m.set("topleft",(selShape.x,selShape.y))
          m.set("width",selShape.w)
          m.set("height",selShape.h)
        }
        else if(selShape.t=="t"){
          type="triangle"
          selShape.x1=document.getElementById('p1x').value;
          selShape.y1=document.getElementById('p1y').value;
          selShape.x2=document.getElementById('p2x').value;
          selShape.y2=document.getElementById('p2y').value;
          selShape.x3=document.getElementById('p3x').value;
          selShape.y3=document.getElementById('p3y').value;
          m.set("first",(selShape.x1,selShape.y1))
          m.set("second",(selShape.x2,selShape.y2))
          m.set("third",(selShape.x3,selShape.y3))
        }
        else if(selShape.t=="c"){
          type="circle"
          selShape.x=document.getElementById('x').value;
          selShape.y=document.getElementById('y').value;
          selShape.w=document.getElementById('rad').value;
          m.set("topleft",(selShape.x,selShape.y))
          m.set("radius",selShape.w)
        }
        else{
          type="ellipse"
          selShape.x=document.getElementById('x').value;
          selShape.y=document.getElementById('y').value;
          selShape.w=document.getElementById('radx').value;
          selShape.h=document.getElementById('rady').value;
          m.set("topleft",(selShape.x,selShape.y))
          m.set("radius_x",selShape.w)
          m.set("radius_y",selShape.h)
        }
        if(n==2){
          var index = list.length;
          list.push(selShape)
          axios.get("http://localhost:8085/create",{
          params:{
            type:type
          }
          })
              .then(function (response) {
                mapping.set(response,index)
                list[index].id=response;
              })
        }



        axios.get("http://localhost:8085/edit", {
          params: {
            id:selShape.id,
            map:m
          }
        })
      }
      //change in list
     list[mapping.get(selShape.id)]=selShape;

     sel=false;
     selShape=null;
      recreate.draw();
      console.log("list :"+list[0] +"  len"+list.length)
      for(var i=0;i<list.length;i++){
        var v =list[i];
        var canvas=document.getElementById('myCanvas');
        this.drawing(v,canvas,true);
      }
    },
    deletes(){
      document.getElementById("model").style.display = "none";
      axios.get("http://localhost:8085/delete", {
        params: {
          id: selShape.id
        }
      })

      var index =list.indexOf(selShape);
      mapping.set(selShape.id,null)
      list.splice(index,1)
      this.redraw(false)
    },
    copy(){
      document.getElementById("copy").style.display = "none";
      document.getElementById("del").style.display = "none";
      document.getElementById("ok").style.display = "none";
      document.getElementById("ok2").style.display = "block";
      document.getElementById("co").style.display = "block";
    },
    clear(){
      recreate.draw();
      list =[];
      mapping=new Map(); // key =id,value = index
      sel=false;
      selShape=null;
    },
    set_list(m){
      var newList=[]
      m.forEach( (value, key) => {
        var id =key;
        var type = value.get("type");
        var fillcolor=value.get("fillcolor"),
            borderwidth=value.get("borderwidth"),
            bordercolor=value.get("bordercolor"),
            border=false;
            if(value.has("bordercolor")&&bordercolor!=null&&bordercolor!=undefined){
              border=true
            }
        var i=newList.length
        if(type=="line"){
          var first=value.get("first"),
              second=value.get("second");
          newList.push(new shape(first.split(",")[0],first.split(",")[1],second.split(",")[0],second.split(",")[1],
              0,0,0,0,0,0,
              fillcolor,border,borderwidth,bordercolor,"l"));
          newList[i].id=id;
        }
        else if(type=="square"||type=="rectangle"){
          var top=value.get("topleft"),
              wid=value.get("width"),
              h=value.get("height"),
              t="s";
          if(type=="rectangle"){
            t="r";
          }
          newList.push(new shape(top.split(",")[0],top.split(",")[1],wid,h,
          0,0,0,0,0,0,fillcolor,border,
          borderwidth,bordercolor,t));
          newList[i].id=id;

        }
        else if(type == "triangle"){
          var first0=value.get("first"),
              second0=value.get("second"),
              third=value.get("third");
          newList.push(new shape(0,0,0,0,first0.split(",")[0],first0.split(",")[1],
          second0.split(",")[0],second0.split(",")[1],third.split(",")[0],third.split(",")[1],fillcolor,border,borderwidth
              ,bordercolor,"t"))
          newList[i].id=id;
        }
        else if(type=="circle"){
          var top0=value.get("topleft"),
              rad=value.get("radius");
          newList.push(new shape(top0.split(",")[0],top0.split(",")[1],rad,0,
          0,0,0,0,0,0,fillcolor,border,
          borderwidth,bordercolor,"c"));
          newList[i].id=id;

        }
        else{
          var top1=value.get("topleft"),
              radx=value.get("radius_x"),
              rady=value.get("radius_y");
          newList.push(new shape(top1.split(",")[0],top1.split(",")[1],radx,rady,
              0,0,0,0,0,0,fillcolor,border,
              borderwidth,bordercolor,"e"));
          newList[i].id=id;
        }
      });
      list=newList;
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
.modalsh {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  padding-top: 80px; /* Location of the box */
  padding-left: 20px;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.content {
  background-color: #fefefe;
  margin: auto;
  overflow: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 35%;
  height: 30%;
}
#close,#del,#copy,#ok{
  cursor: pointer;
  padding: 0px;
  width: 50px;
  height: 50px;
  display: inline;
}
#close{
  width: 15px;
  height: 15px;
  margin:0px ;
  float: right;
}
#ok,#ok2{
  margin-top: 6px;
  float: right;
}
label{
  padding: 5px;
  margin-top: 7px;
  border: solid;
  border-color: #2197be;
  border-radius: 50%;
}

input{
  margin: 10px;
  width: 50px;
  height: 30px;
  border-width: 2px;
  border-radius: 3px;
}
span{
  padding: 5px;
  margin: 0px;
  margin-top: 10px;
  margin-bottom: 10px;
  font-size: 20px;
  font-weight: bolder;
  color: #2197be;

}

#mode1,#mode2,#mode3 ,#tmode,#mode0,#mode,#lmode,#co,#ok2{
display: none;
}
</style>