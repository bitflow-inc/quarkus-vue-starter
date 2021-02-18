<template>
  <nav
    class="md:left-0 md:block md:fixed md:top-0 md:bottom-0 md:overflow-y-auto md:flex-row md:flex-no-wrap md:overflow-hidden shadow-xl bg-white flex flex-wrap items-center justify-between relative md:w-64 z-10 py-4 px-6"
  >
    <!-- md:flex-col md:items-stretch md:min-h-full md:flex-no-wrap px-0 flex flex-wrap items-center justify-between w-full mx-auto -->
    <div
      class=""
    >
      <!-- Toggler -->
      <button
        class="cursor-pointer text-black opacity-50 md:hidden px-3 py-1 text-xl leading-none bg-transparent rounded border border-solid border-transparent"
        type="button"
        v-on:click="toggleCollapseShow('bg-white m-2 py-3 px-6')"
      >
        <i class="fas fa-bars"></i>
      </button>
      <!-- Brand -->
      <a
        class="md:block text-left md:pb-2 text-gray-700 mr-0 inline-block whitespace-no-wrap text-sm uppercase font-bold p-4 px-0"
        href="javascript:void(0)"
      >
        <img
            alt="..."
            class="w-full align-middle border-none"
            src="../assets/img/logo-300.png"
        />
      </a>
      <!-- User -->
      <ul class="md:hidden items-center flex flex-wrap list-none">
        <li class="inline-block relative">
          <notification-dropdown-component></notification-dropdown-component>
        </li>
        <li class="inline-block relative">
          <user-dropdown-component></user-dropdown-component>
        </li>
      </ul>
      <!-- Collapse -->
      <div
        class="md:flex md:flex-col md:items-stretch md:opacity-100 md:relative md:mt-4 md:shadow-none shadow absolute top-0 left-0 right-0 z-40 overflow-y-auto overflow-x-hidden h-auto items-center flex-1 rounded"
        v-bind:class="collapseShow"
      >
        <!-- Form -->
        <form class="mt-6 mb-4 md:hidden">
          <div class="mb-3 pt-0">
            <input
              type="text"
              placeholder="Search"
              class="px-3 py-2 h-12 border border-solid  border-gray-600 placeholder-gray-400 text-gray-700 bg-white rounded text-base leading-snug shadow-none outline-none focus:outline-none w-full font-normal"
            />
          </div>
        </form>
        <!-- Navigation -->
        <ul class="md:flex-col md:min-w-full flex flex-col list-none">
          <li class="items-center">
            <a
              class="text-pink-500 hover:text-pink-600 text-xs uppercase py-3 font-bold block"
              href="#/dashboard"
              ><i class="fas fa-tv opacity-75 mr-2 text-sm"></i>
              Dashboard</a
            >
          </li>
          <li class="items-center">
            <a
              class="text-gray-800 hover:text-gray-600 text-xs uppercase py-3 font-bold block"
              href="#/landing"
              ><i class="fas fa-newspaper text-gray-500 mr-2 text-sm"></i>
              Transactions</a
            >
          </li>
          <li class="items-center">
            <a
              class="text-gray-800 hover:text-gray-600 text-xs uppercase py-3 font-bold block"
              href="#/profile"
              ><i class="fas fa-user-circle text-gray-500 mr-2 text-sm"></i>
              Activities</a
            >
          </li>
          <li class="items-center">
            <a
              class="text-gray-800 hover:text-gray-600 text-xs uppercase py-3 font-bold block"
              href="#/login"
              ><i class="fas fa-fingerprint text-gray-500 mr-2 text-sm"></i>
              Wallets</a
            >
          </li>
          <li class="items-center">
            <a
                class="text-gray-800 hover:text-gray-600 text-xs uppercase py-3 font-bold block"
                href="/q/swagger-ui" target="openapi"
            ><i class="fas fa-fingerprint text-gray-500 mr-2 text-sm"></i>
              OpenAPI</a
            >
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>
<script>
import NotificationDropdownComponent from "./NotificationDropdown.vue";
import UserDropdownComponent from "./UserDropdown.vue";
export default {
  data() {
    return {
      collapseShow: "hidden"
    };
  },
  methods: {
    toggleCollapseShow: function(classes) {
      this.collapseShow = classes;
    }
  },
  components: {
    NotificationDropdownComponent,
    UserDropdownComponent
  }
};
</script>
