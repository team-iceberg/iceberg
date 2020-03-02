package iceberg.dao;

import iceberg.models.Role;
import iceberg.models.User;
import java.util.List;

public interface UserDao {

  /**
   * Get user by mail
   *
   * @return {@link User}
   */
  User getByMail(String mail);

  /**
   * Get role of user by mail
   *
   * @return List of {@link Role}
   */
  List<Role> getRolesByUser(int id);
}
