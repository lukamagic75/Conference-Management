<template>
  <div class="field">
    <label class="label">{{ label }}</label>
    <div class="control">
      <input class="input" :type="type" v-model="modelValue" @input="$emit('update:modelValue', modelValue)">
    </div>
  </div>
</template>

<script>
export default {
  props: {
    label: String,
    type: {
      type: String,
      default: 'text'
    },
    modelValue: String
  }
};
</script>

<style scoped>
.field {
  margin-bottom: 15px;
}
.input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}
</style>
