<template>
  <div id="con">
  <label for="border">Border color:</label>
  <input type="color" id="border" value="#347bc1">
  <label for="bwidth">Border width:</label>
  <input type="number" id="bwidth" name="points" step="1" min="0" >
  <label for="fill">Fill color:</label>
  <input type="color" id="fill" value="#347bc1">
  <button id="del" disabled> delete </button>
  </div>
</template>

<script>
export default {
  name: "Tools"
}
</script>

<style scoped>
#con{
  margin-left: 200px;
}
label{
  padding: 10px;
  border: 3px double #a7acb1;
  border-radius: 50%;
  background: #dfecf5;
  font-size: 25px;
  font-weight: normal;
  margin: 5px;
  display: inline;
}
input{
  width: 30px;
  height: 30px;
  background: #dfecf5;

  display: inline;
  margin: 30px 80px 20px 20px;
}
#bwidth{
  width: 50px;
  text-align: center;
  font-size: 15px;
}
#border{
}
button{
  font-weight: bold;
  margin-top: 0px;
  background: beige;
  margin-left: 100px;
  height: 50px;
  width: 50px;
  border-radius: 100%;
  cursor: not-allowed;
}


</style>