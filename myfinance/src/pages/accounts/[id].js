import { useRouter } from "next/router"
import Layout from "../../../components/Layout"

export default function AccountPage() {
    const router = useRouter()
    console.log(router)
    return (
        <Layout>
            <h1> An Account </h1>
            <h3> {router.query.id}</h3>
        </Layout>

    )
}