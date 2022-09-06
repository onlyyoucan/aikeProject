import request from '@/utils/request'

// 查询个人档案列表
export function listArchives(query) {
  return request({
    url: '/system/archives/list',
    method: 'get',
    params: query
  })
}

// 查询个人档案详细
export function getArchives(id) {
  return request({
    url: '/system/archives/' + id,
    method: 'get'
  })
}

// 新增个人档案
export function addArchives(data) {
  return request({
    url: '/system/archives',
    method: 'post',
    data: data
  })
}

// 修改个人档案
export function updateArchives(data) {
  return request({
    url: '/system/archives',
    method: 'put',
    data: data
  })
}

// 删除个人档案
export function delArchives(id) {
  return request({
    url: '/system/archives/' + id,
    method: 'delete'
  })
}
