<template lang="pug">
  section.components-container
    .w-100.bg-white.p-3
      el-form(:inline='true', :model='filter', size='small')
        el-form-item
          el-input.w-300p(v-model='filter.k', placeholder='请输入查询内容')
        el-form-item
          el-button(type='primary' icon="el-icon-search" @click='loadList') Search
        // 列表
      el-table.mt-3(:data='patients', highlight-current-row='', :loading='listLoading', border='',@row-dblclick='handleView',@sort-change="sortChange", stripe='')
        el-table-column(prop='firstName', label='名称',sortable="custom",align='center', min-width="120")
        el-table-column(prop='lastName', label='重点业务区域',sortable="custom",align='center', min-width="120")
        el-table-column(prop='birthday', label='伙伴等级',sortable="custom" width='140', align='center ')
          template(slot-scope='scope')
            span {{scope.row.birthday | formatDay}}
        el-table-column(prop='type', label='联系电话',  align='center', width="120")
          template(slot-scope='scope')
            span {{scope.row.type}}
        el-table-column(prop='region', label='简介',  align='center', width="120")
        el-table-column(prop='crt', label='创建时间',sortable="custom",width='140', align='center ')
          template(slot-scope='scope')
            span {{scope.row.crt | formatDay}}
        el-table-column(label='操作', width='140', align='center' fixed="right")
          template(slot-scope='scope')
            el-button(size='small', @click='handleView(scope.row)', type='primary', icon='el-icon-edit', plain, circle)
      .col-12.mt-3
        .row.justify-content-end
          el-pagination(@size-change='onPageSizeChanged', @current-change='onPageChanged', :current-page='filter.p', :page-sizes='[10, 20, 50]', :page-size='filter.ps', layout='total, sizes, prev, pager, next, jumper', :total='pager.count')

</template>

<script>
import API from '@/api/api'
export default {
  name: 'StorageInventory',
  data() {
    return {
      filter: {
        k: '',
        p: 1,
        ps: 10,
        prop: '',
        order: '',
        type: ''
      },
      listLoading: false,
      pager: {
        page: 1,
        pageSize: 10,
        count: 0
      },
      patients: []
    }
  },
  watch: {
    stage: function() {
      this.loadList()
    }
  },
  methods: {
    onPageSizeChanged: function(val) {
      this.filter.ps = val
      this.filter.p = 1
      this.loadList()
    },
    onPageChanged: function(val) {
      this.filter.p = val
      this.loadList()
    },
    loadList: function() {
      API.stbInventory
        .list(this.filter)
        .then(res => {
          this.patients = res.data.data
          for (let i = 0; i < this.patients.length; i++) {
            if (this.patients[i].birthday === '0001-01-01T00:00:00Z') {
              this.patients[i].birthday = ''
            }
          }
          this.listLoading = true
          this.pager.count = parseInt(res.data.page.cnt)
        })
        .catch(function() {
          this.$message.error(this.$t('message.upload.failed'))
        })
    },
    handleView: function(val) {
      this.$router.push({
        path: '/patient/' + val.patientId,
        query: { k: this.filter.k, source: 'PH', tab: 'storageBilling' }
      })
    },
    sortChange: function(column) {
      if (column.prop == null || column.order == null) {
        this.filter.prop = ''
        this.filter.order = ''
      } else {
        let prop = ''
        if (column.order === 'ascending') {
          column.order = 'asc'
        } else {
          column.order = 'desc'
        }
        if (column.prop === 'firstName') {
          prop = 'first_name'
        } else if (column.prop === 'lastName') {
          prop = 'last_name'
        } else {
          prop = column.prop
        }
        this.filter.prop = prop
        this.filter.order = column.order
      }
      // API.patient.filter(this.filter).then(res => {
      //   this.pager.count = parseInt(res.data.page.cnt)
      //   this.patients = res.data.data
      //   this.listLoading = true
      // })
    }
  },
  mounted() {
    this.$watch('$route.meta.type', function(newVal) {
      this.filter.type = newVal
      this.loadList()
    })
    this.loadList()
  }
}
</script>

<style scoped></style>
