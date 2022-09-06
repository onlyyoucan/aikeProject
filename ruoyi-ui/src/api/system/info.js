import request from '@/utils/request'

// 查询门诊卡信息列表
export function listInfo(query) {
  return request({
    url: '/system/info/list',
    method: 'get',
    params: query
  })
}

// 查询门诊卡信息详细
export function getInfo(id) {
  return request({
    url: '/system/info/' + id,
    method: 'get'
  })
}

// 新增门诊卡信息
export function addInfo(data) {
  return request({
    url: '/system/info',
    method: 'post',
    data: data
  })
}

//新增建档
export function jiandangInfo(data) {
  return request({
    url: '/system/info/addJiandang',
    method: 'post',
    data: data
  })
}

// 修改门诊卡信息
export function updateInfo(data) {
  return request({
    url: '/system/info',
    method: 'put',
    data: data
  })
}

// 删除门诊卡信息
export function delInfo(id) {
  return request({
    url: '/system/info/' + id,
    method: 'delete'
  })
}
