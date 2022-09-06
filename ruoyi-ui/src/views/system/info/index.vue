<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="金额" prop="money">
        <el-input
          v-model="queryParams.money"
          placeholder="请输入金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="启用日期" prop="enabletime">
        <el-date-picker clearable
          v-model="queryParams.enabletime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择启用日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="挂失日期" prop="losstime">
        <el-date-picker clearable
          v-model="queryParams.losstime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择挂失日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="卡作废日期" prop="deadtime">
        <el-date-picker clearable
          v-model="queryParams.deadtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择卡作废日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="退卡日期" prop="returntime">
        <el-date-picker clearable
          v-model="queryParams.returntime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择退卡日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="押金" prop="deposit">
        <el-input
          v-model="queryParams.deposit"
          placeholder="请输入押金"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="个人档案编号" prop="personid">
        <el-input
          v-model="queryParams.personid"
          placeholder="请输入个人档案编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:info:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:info:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:info:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:info:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleJiandang "
          v-hasPermi="['system:info:add']"
        >建档</el-button>
      </el-col>


      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="infoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="门诊卡信息编号" align="center" prop="id" />
      <el-table-column label="金额" align="center" prop="money" />
      <el-table-column label="启用日期" align="center" prop="enabletime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.enabletime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="挂失日期" align="center" prop="losstime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.losstime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="卡作废日期" align="center" prop="deadtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.deadtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="退卡日期" align="center" prop="returntime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.returntime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="押金" align="center" prop="deposit" />
      <el-table-column label="个人档案编号" align="center" prop="personid" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:info:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:info:add']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改门诊卡信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="金额" prop="money">
          <el-input v-model="form.money" placeholder="请输入金额" />
        </el-form-item>
        <el-form-item label="启用日期" prop="enabletime">
          <el-date-picker clearable
            v-model="form.enabletime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择启用日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="挂失日期" prop="losstime">
          <el-date-picker clearable
            v-model="form.losstime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择挂失日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="卡作废日期" prop="deadtime">
          <el-date-picker clearable
            v-model="form.deadtime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择卡作废日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="退卡日期" prop="returntime">
          <el-date-picker clearable
            v-model="form.returntime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择退卡日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="押金" prop="deposit">
          <el-input v-model="form.deposit" placeholder="请输入押金" />
        </el-form-item>
        <el-form-item label="个人档案编号" prop="personid">
          <el-input v-model="form.personid" placeholder="请输入个人档案编号" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listInfo, getInfo, delInfo, addInfo, updateInfo, jiandangInfo } from "@/api/system/info";

export default {
  name: "Info",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 门诊卡信息表格数据
      infoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        money: null,
        enabletime: null,
        losstime: null,
        deadtime: null,
        returntime: null,
        status: null,
        deposit: null,
        personid: null
      },
      // 表单参数
      form: {},
      //表单
      formDto: {
        archives:{},
        outpatientInfo:{}
      },
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询门诊卡信息列表 */
    getList() {
      this.loading = true;
      listInfo(this.queryParams).then(response => {
        this.infoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        money: null,
        enabletime: null,
        losstime: null,
        deadtime: null,
        returntime: null,
        status: 0,
        deposit: null,
        personid: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd(){
      this.reset();
      this.open = true;
      this.title = "添加门诊卡信息";
    },
    handleJiandang() {
      this.reset();
      this.open = true;
      this.title = "新增建档信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getInfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改门诊卡信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateInfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            if (this.title == "新增建档信息") { //新增建档信息
              this.formDto.outpatientInfo = this.form;
              this.formDto.archives.name = "";
              this.formDto.archives.code = "";
              this.formDto.archives.age = "";
              this.formDto.archives.sex = "";
              jiandangInfo(this.formDto).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            } else {  //新增门诊卡信息
              addInfo(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }

          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除门诊卡信息编号为"' + ids + '"的数据项？').then(function() {
        return delInfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/info/export', {
        ...this.queryParams
      }, `info_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
