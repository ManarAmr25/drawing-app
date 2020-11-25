<template>
  <nav>
    <button>new</button>
    <button>save</button>
    <button>upload</button>
    <button>undo</button>
    <button>redo</button>
    <button>delete</button>
    <button>color</button>
    <button>shapes</button>
  </nav>
  <canvas></canvas>
  <div>{{ x }}, {{ y }}</div>
</template>

<script>
export default {
  name: "App",
  components: {},
  data() {
    return {
      x: 0,
      y: 0,
    };
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
