package starter.domain.response;

import java.util.List;

public record ApiResponse(int page,
                          int per_page,
                          int total,
                          int total_pages,
                          List<Data> data,
                          Support support) { // Support alanını ekleyin

    public record Data(
            int id,
            String email,
            String first_name,
            String last_name,
            String avatar) {} // Avatar alanını ekleyin

    public record Support(String url, String text) {} // Support record'unu tanımlayın
}