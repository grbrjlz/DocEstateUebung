const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '^/immobilien': {
        target: 'http://localhost:8080',
        secure: false,
        ws:true,
      }
    }
  }
})
