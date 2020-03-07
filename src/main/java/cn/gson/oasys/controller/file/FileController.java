package cn.gson.oasys.controller.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.serviceV2.fileV2.FileListServiceV2;
import cn.gson.oasys.serviceV2.fileV2.FilePathServiceV2;
import cn.gson.oasys.serviceV2.fileV2.FileServiceV2;
import cn.gson.oasys.model.po.FileListPO;
import cn.gson.oasys.model.po.FilePathPO;
import cn.gson.oasys.model.po.UserPO;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import cn.gson.oasys.model.dao.filedao.FileListdao;
import cn.gson.oasys.model.dao.filedao.FilePathdao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.services.file.FileServices;

@Controller
@RequestMapping("/")
public class FileController {
    @Autowired
    private FileServices fs;
    @Autowired
    private FilePathdao fpdao;
    @Autowired
    private FileListdao fldao;
    @Autowired
    private UserDao udao;

    /**
     * 第一次进入
     *
     * @param model
     * @return
     */
/*	@RequestMapping("filemanage")
	public String usermanage(@SessionAttribute("userId")Long userid,Model model) {
		System.out.println(userid);
		User user = udao.findOne(userid);
		
		FilePath filepath = fpdao.findByPathName(user.getUserName());
		
		System.out.println(filepath);
		
		if(filepath == null){
			FilePath filepath1 = new FilePath();
			filepath1.setParentId(1L);
			filepath1.setPathName(user.getUserName());
			filepath1.setPathUserId(user.getUserId());
			filepath = fpdao.save(filepath1);
		}
		
		model.addAttribute("nowpath", filepath);
		model.addAttribute("paths", fs.findpathByparent(filepath.getId()));
		model.addAttribute("files", fs.findfileBypath(filepath));
		
		model.addAttribute("userrootpath",filepath);
		model.addAttribute("mcpaths",fs.findpathByparent(filepath.getId()));
		return "file/filemanage";
	}
*/
    /*  *//**
     * 图片预览
     * @param response
     * @param fileid
     *//*
    @RequestMapping("imgshow")
    public void imgshow(HttpServletResponse response, @RequestParam("fileid") Long fileid) {
        FileList filelist = fldao.findOne(fileid);
        File file = fs.getFile(filelist.getFilePath());
        writefile(response, file);
    }

    */

    /*	*//*
     *//**
     * 写文件 方法
     *
     * @param response
     * @param file
     * @throws IOException
     *//*
    public void writefile(HttpServletResponse response, File file) {
        ServletOutputStream sos = null;
        FileInputStream aa = null;
        try {
            aa = new FileInputStream(file);
            sos = response.getOutputStream();
            // 读取文件问字节码
            byte[] data = new byte[(int) file.length()];
            IOUtils.readFully(aa, data);
            // 将文件流输出到浏览器
            IOUtils.write(data, sos);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                sos.close();
                aa.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
*/
    //-------------------

    /**
     * 下载文件
     *
     * @param response
     * @param fileid
     *//*
    @RequestMapping("downfile")
    public void downFile(HttpServletResponse response, @RequestParam("fileid") Long fileid) {
        try {
            FileList filelist = fldao.findOne(fileid);
            File file = fs.getFile(filelist.getFilePath());
            response.setContentLength(filelist.getSize().intValue());
            response.setContentType(filelist.getContentType());
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(filelist.getFileName().getBytes("UTF-8"), "ISO8859-1"));
            writefile(response, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    */


    /*	*//**
     * 进入指定文件夹 的controller方法
     *
     * @param pathid
     * @param model
     * @return
     *//*
	@RequestMapping("filetest")
	public String text(@SessionAttribute("userId")Long userid,@RequestParam("pathid") Long pathid, Model model) {
		User user = udao.findOne(userid);
		FilePath userrootpath = fpdao.findByPathName(user.getUserName());
		
		// 查询当前目录
		FilePath filepath = fpdao.findOne(pathid);

		// 查询当前目录的所有父级目录
		List<FilePath> allparentpaths = new ArrayList<>();
		fs.findAllParent(filepath, allparentpaths);
		Collections.reverse(allparentpaths);

		model.addAttribute("allparentpaths", allparentpaths);
		model.addAttribute("nowpath", filepath);
		model.addAttribute("paths", fs.findpathByparent(filepath.getId()));
		model.addAttribute("files", fs.findfileBypath(filepath));
		//复制移动显示 目录
		model.addAttribute("userrootpath",userrootpath);
		model.addAttribute("mcpaths",fs.findpathByparent(userrootpath.getId()));
		return "file/filemanage";
	}

	*//**
     * 文件上传 controller方法
     *
     * @param file
     * @param pathid
     * @param session
     * @param model
     * @return
     * @throws IllegalStateException
     * @throws IOException
     *//*
	@RequestMapping("fileupload")
	public String uploadfile(@RequestParam("file") MultipartFile file, @RequestParam("pathid") Long pathid,
			HttpSession session, Model model) throws IllegalStateException, IOException {
		Long userid = Long.parseLong(session.getAttribute("userId") + "");
		User user = udao.findOne(userid);
		FilePath nowpath = fpdao.findOne(pathid);
		// true 表示从文件使用上传
		FileList uploadfile = (FileList) fs.savefile(file, user, nowpath, true);
		System.out.println(uploadfile);
		
		model.addAttribute("pathid", pathid);
		return "forward:/filetest";
	}
	*/
    /*

     */
/**
 * 文件分享
 *
 * @param pathid
 * @param checkfileids
 * @param model
 * @return
 *//*

    @RequestMapping("doshare")
    public String doshare(@RequestParam("pathid") Long pathid,
                          @RequestParam("checkfileids") List<Long> checkfileids,
                          Model model) {
        if (!checkfileids.isEmpty()) {
            System.out.println(checkfileids);
            fs.doshare(checkfileids);
        }
        model.addAttribute("pathid", pathid);
        model.addAttribute("message", "分享成功");
        return "forward:/filetest";
    }

    */
/**
 * 删除前台选择的文件以及文件夹
 *
 * @param pathid
 * @param checkpathids
 * @param checkfileids
 * @param model
 * @return
 *//*

    @RequestMapping("deletefile")
    public String deletefile(@SessionAttribute("userId") Long userid,
                             @RequestParam("pathid") Long pathid,
                             @RequestParam("checkpathids") List<Long> checkpathids,
                             @RequestParam("checkfileids") List<Long> checkfileids, Model model) {
        System.out.println(checkfileids);
        System.out.println(checkpathids);

        if (!checkfileids.isEmpty()) {
            // 删除文件
            //fs.deleteFile(checkfileids);
            //文件放入回收战
            fs.trashfile(checkfileids, 1L, userid);
        }
        if (!checkpathids.isEmpty()) {
            // 删除文件夹
            //fs.deletePath(checkpathids);
            fs.trashpath(checkpathids, 1L, true);
            //fs.trashPath(checkpathids);
        }

        model.addAttribute("pathid", pathid);
        return "forward:/filetest";
    }

    */
/**
 * 重命名
 *
 * @param name
 * @param renamefp
 * @param pathid
 * @param model
 * @return
 *//*


    @RequestMapping("rename")
    public String rename(@RequestParam("name") String name,
                         @RequestParam("renamefp") Long renamefp,
                         @RequestParam("pathid") Long pathid,
                         @RequestParam("isfile") boolean isfile,
                         Model model) {

        //这里调用重命名方法
        fs.rename(name, renamefp, pathid, isfile);

        model.addAttribute("pathid", pathid);
        return "forward:/filetest";

    }

    */
/**
 * 移动和复制
 *
 * @param mctoid
 * @param model
 * @return
 *//*

    @RequestMapping("mcto")
    public String mcto(@SessionAttribute("userId") Long userid,
                       @RequestParam("morc") boolean morc,
                       @RequestParam("mctoid") Long mctoid,
                       @RequestParam("pathid") Long pathid,
                       @RequestParam("mcfileids") List<Long> mcfileids,
                       @RequestParam("mcpathids") List<Long> mcpathids,
                       Model model) {
        System.out.println("--------------------");
        System.out.println("mcfileids" + mcfileids);
        System.out.println("mcpathids" + mcpathids);

        if (morc) {
            System.out.println("这里是移动！~~");
            fs.moveAndcopy(mcfileids, mcpathids, mctoid, true, userid);
        } else {
            System.out.println("这里是复制！~~");
            fs.moveAndcopy(mcfileids, mcpathids, mctoid, false, userid);
        }

        model.addAttribute("pathid", pathid);
        return "forward:/filetest";
    }

    */
    /**
     * 新建文件夹
     *
     * @param pathid
     * @param pathname
     * @param model
     * @return
     *//*

    @RequestMapping("createpath")
    public String createpath(@SessionAttribute("userId") Long userid, @RequestParam("pathid") Long pathid, @RequestParam("pathname") String pathname,
                             Model model) {
        System.out.println(pathid + "aaaaaa" + pathname);
        FilePath filepath = fpdao.findOne(pathid);
        String newname = fs.onlyname(pathname, filepath, null, 1, false);

        FilePath newfilepath = new FilePath(pathid, newname);
        newfilepath.setPathUserId(userid);

        System.out.println(newname);
        System.out.println(newfilepath);
        fpdao.save(newfilepath);

        model.addAttribute("pathid", pathid);
        return "forward:/filetest";
    }
*/


    // @RequestMapping(value = "pathin",method = RequestMethod.POST)
    // public @ResponseBody Map<Integer, Object>
    // pathin(@RequestParam("pathid")Long pathid){
    // FilePath filepath = fpdao.findOne(pathid);
    // if(null == filepath)
    // return null;
    //
    // Map<Integer, Object> maps = new HashMap<>();
    // maps.put(1, fs.findpath(filepath.getId()));
    // maps.put(2, fs.findfileBypath(filepath));
    // System.out.println(maps);
    // return maps;
    // }


    //===============================================
    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private FilePathServiceV2 filePathServiceV2;
    @Resource
    private FileListServiceV2 fileListServiceV2;
    @Resource
    private FileServiceV2 fileServiceV2;

    /**
     * 第一次进入
     *
     * @param model
     * @return
     */
    @RequestMapping("filemanage")
    public String usermanage(@SessionAttribute("userId") Long userId, Model model) {
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);//根据用户id找出用户信息
        FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathName(userPO.getUserName());//根据用户名找用户的文件夹信息
        if (filePathPO == null) {
            //如果文件夹不纯在就根据用户信息新建一个
            filePathPO = filePathServiceV2.insertFilePathPOByUserPO(userPO);
        }
        //根据文件夹父id和文件夹是否是垃圾文件夹找文件夹下的所有文件夹
        List<FilePathPO> filePathPOS = filePathServiceV2.getFilePathPOListByParentIdAndIsTrash(filePathPO.getPathId(), 0L);
        //根据用户的文件夹id找用户下的文件夹列表
        List<FileListPO> fileListPOS = fileListServiceV2.getFileListPOSByFilePathIdAndFileIsTrash(filePathPO.getPathId(), 0L);
        model.addAttribute("nowpath", filePathPO);//单个用户的根文件夹信息
        model.addAttribute("paths", filePathPOS);//文件夹下的所有文件
        model.addAttribute("files", fileListPOS);//根据文件路径id找出的文件列表

        model.addAttribute("userrootpath", filePathPO);//单个用户的根文件夹信息
        model.addAttribute("mcpaths", filePathPOS);//文件夹下的所有文件
        return "file/filemanage";
    }


    /**
     * 图片预览（找出图片的具体位置）
     *
     * @param response
     * @param fileId   要显示的文件id
     */
    @RequestMapping("imgshow")
    public void imgshow(HttpServletResponse response, @RequestParam("fileid") Long fileId) {
        FileListPO fileListPO = fileListServiceV2.getFileListPOByFileListPOId(fileId);
        File file = fileListServiceV2.getFile(fileListPO.getFilePath());
        writeFile(response, file);
    }

    /**
     * 写文件方法
     *
     * @param response
     * @param file     要输出的文件
     * @throws IOException
     */
    public void writeFile(HttpServletResponse response, File file) {
        ServletOutputStream sos = null;
        FileInputStream aa = null;
        try {
            aa = new FileInputStream(file);
            sos = response.getOutputStream();
            // 读取文件的字节码
            byte[] data = new byte[(int) file.length()];
            IOUtils.readFully(aa, data);//根据文件的长度从头读取文件
            // 将文件流输出到浏览器
            IOUtils.write(data, sos);//根据文件长度写文件
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sos.close();
                aa.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//----------------------------------------

    /**
     * 进入指定文件夹 的controller方法
     *
     * @param pathId 当前文件夹id
     * @param model
     * @return
     */
    @RequestMapping("filetest")
    public String text(@SessionAttribute("userId") Long userId, @RequestParam("pathid") Long pathId, Model model) {
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);//根据用户id找用户信息
        FilePathPO userRootFilePathPO = filePathServiceV2.getFilePathPOByPathName(userPO.getUserName());//用户文件夹
        FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(pathId);//当前所在文件夹
        List<FilePathPO> allFilePathPOList = new ArrayList<>();//当前路径的所有父级文件夹
        fileServiceV2.allFilePathPOParent(filePathPO, allFilePathPOList);
        Collections.reverse(allFilePathPOList);//反转数组（当前文件夹的正确所有路径）
        model.addAttribute("allparentpaths", allFilePathPOList);//当前文件夹的所有的父级文件夹
        model.addAttribute("nowpath", filePathPO);//当前文件夹

//       把当前文件夹id当做它的父级id，根据上级文件夹id和文件夹是否是垃圾文件夹,返回当前文件夹的下级文件夹
        List<FilePathPO> filePathPOS = filePathServiceV2.getFilePathPOListByParentIdAndIsTrash(filePathPO.getPathId(), 0L);
        model.addAttribute("paths", filePathPOS);//下级文件夹
        //根据当前文件夹id和是否是垃圾文件，找当前文件夹下的所有的非垃圾文件
        List<FileListPO> fileListPOS = fileListServiceV2.getFileListPOSByFilePathIdAndFileIsTrash(filePathPO.getPathId(), 0L);
        model.addAttribute("files", fileListPOS);

        //复制移动显示 目录
        model.addAttribute("userrootpath", userRootFilePathPO);// 用户的根路径
        //根据用户文件夹id和是否是垃圾文件，找用户下的所有非垃圾文件夹
        List<FilePathPO> filePathPOList = filePathServiceV2.getFilePathPOListByParentIdAndIsTrash(userRootFilePathPO.getPathId(), 0L);
        model.addAttribute("mcpaths", filePathPOList);
        return "file/filemanage";
    }

    /**
     * 文件上传 controller方法
     *
     * @param file
     * @param pathId
     * @param session
     * @param model
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("fileupload")
    public String uploadfile(@RequestParam("file") MultipartFile file, @RequestParam("pathid") Long pathId,
                             HttpSession session, Model model) throws IllegalStateException, IOException {
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);//用户信息
        FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(pathId);//所在文件夹信息
        fileServiceV2.saveFile(file, userPO, filePathPO, true);// true 表示从文件使用上传
        model.addAttribute("pathid", pathId);//上传文件的所属文件夹id
        return "forward:/filetest";
    }

//----------------------------------------


    /**
     * 删除前台选择的文件以及文件夹
     *
     * @param userId       用户id
     * @param pathId       所在文件夹
     * @param checkPathIds 删除前台选择的文件夹ids
     * @param checkFileIds 文件ids
     * @param model
     * @return
     */
    @RequestMapping("deletefile")
    public String deletefile(@SessionAttribute("userId") Long userId,
                             @RequestParam("pathid") Long pathId,
                             @RequestParam("checkpathids") List<Long> checkPathIds,//删除前台选择的文件以及文件夹
                             @RequestParam("checkfileids") List<Long> checkFileIds,//文件ids
                             Model model) {

        if (!checkFileIds.isEmpty()) {
            //文件放入回收战
            fileServiceV2.trashFile(checkFileIds, 1L, userId);
            // 删除文件
//            fs.deleteFile(checkfileids);
        }
        if (!checkPathIds.isEmpty()) {
            //文件夹ids,是否放入回收站，，是否是直接删除的最外层文件夹
            fileServiceV2.trashPath(checkPathIds, 1L, true);
            // 删除文件夹
            //fs.deletePath(checkpathids);
        }

        model.addAttribute("pathid", pathId);
        return "forward:/filetest";
    }

    /**
     * 新建文件夹√
     *
     * @param userId   用户id
     * @param pathId   所属的文件夹id（在哪个里面建文件夹）
     * @param pathname 新建的文件夹名
     * @param model
     * @return
     */
    @RequestMapping("createpath")
    public String createpath(@SessionAttribute("userId") Long userId, @RequestParam("pathid") Long pathId, @RequestParam("pathname") String pathname,
                             Model model) {
        //防止新建的文件夹名重命
        String newPathName = fileServiceV2.onlyname(pathname, pathId, null, 1, false);
        //插入新路径
        filePathServiceV2.insertFilePathPOByNewNameAndParentIdAndUserId(pathId, newPathName, userId);
        model.addAttribute("pathid", pathId);
        return "forward:/filetest";
    }

    /**
     * 文件分享
     *
     * @param pathId       文件的路径id
     * @param checkFileIds 文件id集合
     * @param model
     * @return
     */
    @RequestMapping("doshare")
    public String doshare(@RequestParam("pathid") Long pathId,
                          @RequestParam("checkfileids") List<Long> checkFileIds,
                          Model model) {
        if (!checkFileIds.isEmpty()) {
            fileServiceV2.doShare(checkFileIds);
        }
        model.addAttribute("pathid", pathId);
        model.addAttribute("message", "分享成功");
        return "forward:/filetest";
    }


    /**
     * 重命名
     *
     * @param name     从前端接收的修改名字
     * @param reNameFp 要修改的文件id或文件夹id
     * @param pathId   文件的文件夹id或文件夹的上级文件夹id
     * @param model
     * @return
     */

    @RequestMapping("rename")
    public String rename(@RequestParam("name") String name,
                         @RequestParam("renamefp") Long reNameFp,
                         @RequestParam("pathid") Long pathId,
                         @RequestParam("isfile") boolean isFile,
                         Model model) {

        //这里调用重命名方法（ifFile文件是true,文件夹是false)
        fileServiceV2.rename(name, reNameFp, pathId, isFile);
        model.addAttribute("pathid", pathId);//所属文件夹id
        return "forward:/filetest";// 转发到进入文件夹控制器
    }


    /**
     * 移动和复制
     *
     * @param userId    用户id
     * @param morc      true 为移动
     * @param mctoid    要移动到的文件夹id
     * @param pathId    用户文件夹id
     * @param mcfileids 要移动的文件id
     * @param mcpathids
     * @param model
     * @return
     */
    @RequestMapping("mcto")
    public String mcto(@SessionAttribute("userId") Long userId,
                       @RequestParam("morc") boolean morc,
                       @RequestParam("mctoid") Long mctoid,
                       @RequestParam("pathid") Long pathId,
                       @RequestParam("mcfileids") List<Long> mcfileids,
                       @RequestParam("mcpathids") List<Long> mcpathids,
                       Model model) {
        if (morc) {//是true为移动
            System.out.println("这里是移动！~~");
            fileServiceV2.moveAndCopy(mcfileids, mcpathids, mctoid, true, userId);
        } else {
            System.out.println("这里是复制！~~");
            fileServiceV2.moveAndCopy(mcfileids, mcpathids, mctoid, false, userId);
        }
        model.addAttribute("pathid", pathId);
        return "forward:/filetest";
    }


    /**
     * 下载文件
     *
     * @param response
     * @param fileId
     */
    @RequestMapping("downfile")
    public void downFile(HttpServletResponse response, @RequestParam("fileid") Long fileId) {
        try {
            FileListPO fileListPO = fileListServiceV2.getFileListPOByFileListPOId(fileId);
            File file = fileServiceV2.getFile(fileListPO.getFilePath());//根据文件路径获取文件
            response.setContentLength(fileListPO.getSize().intValue());
            response.setContentType(fileListPO.getContentType());
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileListPO.getFileName().getBytes("UTF-8"), "ISO8859-1"));
            writeFile(response, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
