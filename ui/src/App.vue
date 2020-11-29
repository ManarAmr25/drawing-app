<template>
  <body>
  <div id="container">
    <div id="menu">
      <Menu/>
    </div>

    <div id="shapes">
    <Shapes/>
    </div>

    <div id="navigation_bar">
      {{coo}}
    </div>

    <div id="board"  v-on:mousemove="on">
      <Board/>
    </div>

  </div>
  </body>
</template>

<script >
import Menu from "@/components/Menu";
import Shapes from "@/components/Shapes";
import Board from "@/components/Board";
import { fun} from "@/main";

export default {
  components: { Board, Shapes, Menu},
  data(){
      return({
  coo:''
  })
       },
  methods:{
    on(event){
      this.coo=fun.show(event)
    }
}
}
</script>

<style>
body{
  background: #ececf1;
  overflow: auto;
}
::-webkit-scrollbar{
  border-width: thin;
  width: 5px;
  height: 5px;
}
::-webkit-scrollbar-thumb {
  background: #b7d4fa;
  border-radius: 20%;
}
#container{
  display:grid;
  width: 100%;
  height: 100%;
  grid-template-columns: 180px 1320px ;
  grid-column-gap: 10px;
  grid-row-gap: 5px;
  grid-template-rows: 70px 90px 505px 30px;
  grid-template-areas:
    "menu menu"
    "shape board"
    "shape board"
    "shape bar"
}
#menu,#tools,#shapes,#board,#navigation_bar{
  display: grid;
  border: 1px solid #a29898;


}
#menu{
  grid-area: menu;
  border-radius: 10%;
}

#shapes{
  overflow: auto ;
  overflow-x: hidden;
  background-color: #e6e9f3;
  border-radius: 30px;
  grid-area: shape;

}

#board{
  overflow: auto;
  grid-area: board;
}

#navigation_bar{
  padding: 5px;
  padding-left: 20px;
  grid-area: bar;
}
</style>
