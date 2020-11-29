<template>
  <canvas id="myCanvas" ref="canvas" >
  </canvas>
</template>

<script>
export default {
  name: "Board",
}
</script>

<style scoped>
canvas{
  width: 100%;
  height: 100%;
  background-color:white ;
  border:1px solid #a29898;
  overflow: auto;
  cursor: crosshair;

}

</style>